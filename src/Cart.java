import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    Map<String, Integer> map = new HashMap<>();

    public void showItems(){
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("이름 : " + key + ", 개수: " +  map.get(key));
        }
    };
    public void addProduct(String name, int number){
        if (map.containsKey(name)) {
            int currentNumber = map.get(name);
            map.put(name, currentNumber + number);
        } else {
            map.put(name, number);
        }
    };
    public void removeProducts(String name, int number){
        if (map.containsKey(name)) {
            int currentNumber = map.get(name);
            if (currentNumber < number) {
                System.out.println("장바구니에 보유한 상품의 개수 이상의 수를 입력했습니다.");
            } else if (currentNumber == number) {
                map.remove(name);
            } else {
                map.put(name, currentNumber - number);
            }
        } else {
            System.out.println("장바구니에 없는 상품입니다.");
        }
    };
}
