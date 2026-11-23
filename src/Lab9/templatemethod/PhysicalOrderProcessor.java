package Lab9.templatemethod;

public class PhysicalOrderProcessor extends OrderProcessor {

    @Override
    protected void prepareProduct(Order order) {
        System.out.println("[3. Đóng gói vật lý] Xuất kho sản phẩm '" + order.getProductName() 
                + "', bọc chống sốc và dán tem mã vận đơn.");
    }

    @Override
    protected boolean isGiftWrapRequested(Order order) {
        // Hang vat ly cho phep kich hoạt hook goi qua neu khach yeu cau
        return order.isGiftWrap();
    }

    @Override
    protected void deliverProduct(Order order) {
        System.out.println("[4. Vận chuyển] Bàn giao kiện hàng cho đơn vị giao hàng nhanh (Shipper).");
    }
}