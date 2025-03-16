package hello.core.singleton;

public class StatefulService {

    // 공유 필드는 조심할 것 스프링 빈은 항상 무상태(stateless)로 설계하자.
    private int price;  // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
