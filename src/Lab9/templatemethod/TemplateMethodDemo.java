package Lab9.templatemethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        // TH1: Don hang vat ly co yeu cau goi qua
        Order physicalOrder = new Order(
                "ORD-2026-001", 
                "khachhang1@gmail.com", 
                "Bàn phím cơ không dây", 
                1, 
                1850000, 
                true
        );
        OrderProcessor physicalProcessor = new PhysicalOrderProcessor();
        physicalProcessor.processOrder(physicalOrder);

        // TH2: Đơn hàng sản phẩm số
        Order digitalOrder = new Order(
                "ORD-2026-002", 
                "hocngonngu@gmail.com", 
                "Khóa học ngôn ngữ Trung - HSK 5", 
                1, 
                3690000, 
                true 
                // Dù truyền true nhưng DigitalOrderProcessor không ghi đè hook nên tự động bỏ qua
        );
        OrderProcessor digitalProcessor = new DigitalOrderProcessor();
        digitalProcessor.processOrder(digitalOrder);
    }
}