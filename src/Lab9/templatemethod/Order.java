package Lab9.templatemethod;

public class Order {
    private final String orderId;
    private final String customerEmail;
    private final String productName;
    private final int quantity;
    private final double totalAmount;
    private final boolean giftWrap;

    public Order(String orderId, String customerEmail, String productName, 
                 int quantity, double totalAmount, boolean giftWrap) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.giftWrap = giftWrap;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerEmail() { return customerEmail; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }
    public boolean isGiftWrap() { return giftWrap; }
}