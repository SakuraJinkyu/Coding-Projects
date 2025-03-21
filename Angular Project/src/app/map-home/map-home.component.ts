import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface Country {
  id: string;
  name: string;
  region: { value: string };
  incomeLevel: { value: string };
  capitalCity: string;
  longitude: string;
  latitude: string;
  d?: string;
}

@Component({
  selector: 'app-map-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
})
export class MapHomeComponent implements OnInit {
  countries: Country[] = [];
  selectedCountry: Country | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    const baseUrl = 'https://api.worldbank.org/v2/country/all/?per_page=296&format=json';

    this.http.get<any[]>(`${baseUrl}`).subscribe({
      next: (response) => {
        if (response && response.length > 1 && Array.isArray(response[1])) {
          const countriesPage = response[1].map((entry: any) => ({
            id: entry.iso2Code.toLowerCase(),
            name: entry.name,
            region: entry.region?.value || '',
            incomeLevel: entry.incomeLevel?.value || '',
            capitalCity: entry.capitalCity || '',
            longitude: entry.longitude || '',
            latitude: entry.latitude || '',
          }));
          this.countries = countriesPage;
          console.log('All countries loaded:', this.countries);
        } else {
          console.error('Unexpected API response format:', response);
        }
      },
      error: (err) => {
        console.error('Failed to fetch data:', err);
      },
    });
    
  }

  selectCountryById(id: string) {
    const country = this.countries.find(c => c.id === id.toLowerCase());
    if (country) {
      console.log('Country selected:', country);
      this.selectedCountry = country;
    } else {
      console.error('Country ID not found:', id);
    }
  }


onPathClick(event: MouseEvent): void {
  const pathId = (event.target as SVGPathElement).id;
  if (pathId) {
    this.selectedCountry = this.countries.find(country => country.id === pathId) ?? null;
    console.log('Country details:', this.selectedCountry);
  } else {
    console.error('Path ID not found');
  }
}

}