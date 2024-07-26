import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartApp2 {
    public static void main(String[] args) {

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
        //csv read
        BufferedReader br = null;
        String line;
        String path = "/Users/leesangjun/Documents/학습/goorm/assignment/cart/cart/src/data.csv";

        List<Product> myProducts = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            //한 줄 씩 읽기
            while ((line = br.readLine()) != null) {
                //csv 이니까 ,로 라인을 쪼갬
                String[] temp = line.split(",");

                Product product = new Product(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
                productSet.add(product);

                myProducts.add(product);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        System.out.println("[장바구니]");
        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(myProducts.get(0), 3);
        myCart.addProduct(myProducts.get(1), 5);
        myCart.addProduct(myProducts.get(1), 4);


        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct(myProducts.get(0), 3);
        myCart.removeProduct(myProducts.get(1), 5);
        myCart.removeProduct(myProducts.get(1), 10);


        // TODO: 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();
        System.out.println(myCart.showItemsStream());

    }
}
