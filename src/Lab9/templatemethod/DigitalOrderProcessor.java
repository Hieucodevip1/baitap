package Lab9.templatemethod;

public class DigitalOrderProcessor extends OrderProcessor {

    @Override
    protected void prepareProduct(Order order) {
        System.out.println("[3. Cấp phát số] Khởi tạo mã kích hoạt (License Key) và mở quyền truy cập cho '" 
                + order.getProductName() + "'.");
    }

    @Override
    protected void deliverProduct(Order order) {
        System.out.println("[4. Giao hàng điện tử] Gửi liên kết tải xuống (Download Link) trực tiếp vào tài khoản khách hàng.");
    }
}