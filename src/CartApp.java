import java.util.HashSet;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        System.out.println("[상품 목록]");
        Product milk = new Product(1, "우유", 300);
        Product apple = new Product(2, "사과", 500);
        Product apple2 = new Product(2, "사과", 500);

        //TODO : 상품 클래스를 생성하여 상품목록에 넣는다.
        productSet.add(milk);
        productSet.add(apple);
        productSet.add(apple2);

        System.out.println("상품 개수: " + productSet.size());
        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println();

        // 장바구니 생성
        Cart myCart = new Cart();

        System.out.println("[장바구니]");
        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(milk, 3);
        myCart.addProduct(apple, 5);
        myCart.addProduct(apple, 4);

        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct(milk, 3);
        myCart.removeProduct(apple, 5);
        myCart.removeProduct(apple, 10);

        // TODO: 장바구니에 현재 담긴 상품들을 출력 ( 상품이름, 각 상품의 갯수)
        myCart.showItems();
        System.out.println(myCart.showItemsStream());
    }
}
