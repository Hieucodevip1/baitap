package Lab9.templatemethod;

public abstract class OrderProcessor {

    // TEMPLATE METHOD: Khoa thu tu quy trinh = final
    public final void processOrder(Order order) {
        
        System.out.println("BẮT ĐẦU XỬ LÝ ĐƠN HÀNG: " + order.getOrderId());
        
        if (!validateOrder(order)) {
            System.out.println("[LỖI] Đơn hàng không hợp lệ. Hủy quy trình!");
            return;
        }
        
        processPayment(order);
        prepareProduct(order);
        
        // Sử dụng Hook method để tùy biến hành vi mở rộng
        if (isGiftWrapRequested(order)) {
            wrapAsGift(order);
        }
        
        deliverProduct(order);
        sendNotification(order);
        
        System.out.println("HOÀN TẤT ĐƠN HÀNG: " + order.getOrderId());    
    }

    // B1: Co dinh, kiem tra tinh hop le
    protected boolean validateOrder(Order order) {
        System.out.println("[1. Xác thực] Kiểm tra thông tin sản phẩm '" + order.getProductName() 
                + "' (Số lượng: " + order.getQuantity() + ")...");
        return order != null && order.getQuantity() > 0 && order.getTotalAmount() > 0;
    }

    // B2: Co dinh, thanh toan
    protected void processPayment(Order order) {
        System.out.printf("[2. Thanh toán] Đã thu %.0f VNĐ qua cổng thanh toán trực tuyến.%n", 
                order.getTotalAmount());
    }

    // B3: Bien thien, chuan bi hang, bat buoc lop con cai dat
    protected abstract void prepareProduct(Order order);

    // Hook method: Tuy chon, mac dinh khong goi qua
    protected boolean isGiftWrapRequested(Order order) {
        return false;
    }

    private void wrapAsGift(Order order) {
        System.out.println("   -> [Mở rộng] Thực hiện gói quà cao cấp và đính kèm thiệp chúc mừng.");
    }

    // B4: Bien thien, giao hang
    protected abstract void deliverProduct(Order order);

    // B5: Co dinh, gui thong bao hoan tat
    protected void sendNotification(Order order) {
        System.out.println("[5. Thông báo] Đã gửi hóa đơn điện tử tới email: " + order.getCustomerEmail());
    }
}