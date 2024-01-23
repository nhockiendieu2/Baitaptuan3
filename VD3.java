
package baitaptuan3;

public class VD3 {
    public int count =0;
    public synchronized void demTang()
    {
        count++;
    }
    public synchronized void demGiam()
    {
        count-=2;
    }
    
    public int getCount() // Phuong thuc khong dong bo hoa
    {
        return count;
    }
    public static void main(String[] args) {
        VD3 c = new VD3();
        Thread inTh = new Thread(()->{
                for(int i=0;i<1000;i++){ // Tao luong tang
                    c.demTang(); // Goi ham dong bo hoa
                }
        });
        Thread deTh = new Thread(()->{
                for(int i=0;i<1000;i++){ // Tao luong giam
                    c.demGiam(); // Goi ham dong bo hoa
                }
        });
        
        inTh.start(); // Chay luong
        deTh.start();
        try {
            inTh.join(); // Doi luong nay hoan thanh roi moi xu ly tiep
            deTh.join(); // Doi luong nay hoan thanh roi moi xu ly tiep
        } catch (Exception e) {
        }
        // In ra ket qua cuoi cung
        System.out.println("Ket qua cuoi cung: "
                + c.getCount());
        
    }
}
