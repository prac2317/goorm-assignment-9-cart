import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {
    Map<Product, Integer> item = new HashMap<>();

    public void showItems(){
        Set<Product> keySet = item.keySet();
        for (Product product : keySet) {
            System.out.println("이름 : " + product.getName() + ", 개수: " +  item.get(product));
        }
    };
    public void addProduct(Product product, int number){
        if (item.containsKey(product)) {
            int currentNumber = item.get(product);
            item.put(product, currentNumber + number);
        } else {
            item.put(product, number);
        }
    };
    public void removeProduct(Product product, int number){
        if (item.containsKey(product)) {
            int currentNumber = item.get(product);
            if (currentNumber < number) {
                System.out.println("장바구니에 보유한 상품의 개수 이상의 수를 입력했습니다.");
            } else if (currentNumber == number) {
                item.remove(product);
            } else {
                item.put(product, currentNumber - number);
            }
        } else {
            System.out.println("장바구니에 없는 상품입니다.");
        }
    };

    public Map<String, Integer> showItemsStream() {
        return item.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
    }
}
