package CG.washer.GreenCarWash.wrapperclass;

public class OrderReceipt {
	private String orderID;
    private String customerEmail;
    private String washerName;
    private String washPackName;
    private String washPackDetails;
    private int washPckPrice;
   public OrderReceipt()
    {

 

    }
    public OrderReceipt(String orderID, String customerEmail1, String washerName1, String washPackName,
            String washPackDetails, int washPckPrice) {
        super();
        this.orderID = orderID;
        customerEmail = customerEmail1;
        washerName = washerName1;
        this.washPackName = washPackName;
        this.washPackDetails = washPackDetails;
        this.washPckPrice = washPckPrice;
    }
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail1) {
        customerEmail = customerEmail1;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName1) {
        washerName = washerName1;
    }
    public String getWashPackName() {
        return washPackName;
    }
    public void setWashPackName(String washPackName) {
        this.washPackName = washPackName;
    }
    public String getWashPackDetails() {
        return washPackDetails;
    }
    public void setWashPackDetails(String washPackDetails) {
        this.washPackDetails = washPackDetails;
    }
    public int getWashPckPrice() {
        return washPckPrice;
    }
    public void setWashPckPrice(int washPckPrice) {
        this.washPckPrice = washPckPrice;
    }

}
