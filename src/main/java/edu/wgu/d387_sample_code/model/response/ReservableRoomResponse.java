package edu.wgu.d387_sample_code.model.response;

import edu.wgu.d387_sample_code.model.Links;


public class ReservableRoomResponse {

    private Long id;
    private Integer roomNumber;
    private Integer price;
    private String priceUSD;
    private String priceCAD;
    private String priceEUR;
    private Links links;

    public ReservableRoomResponse() {
        super();
    }

    public ReservableRoomResponse(Integer roomNumber, Integer price) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.priceUSD = "$" + price;
        this.priceCAD = "C$" + price;
        this.priceEUR = "€" + price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(String priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getPriceCAD() {
        return priceCAD;
    }

    public void setPriceCAD(String priceCAD) {
        this.priceCAD = priceCAD;
    }

    public String getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(String priceEUR) {
        this.priceEUR = priceEUR;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }


}
