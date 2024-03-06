package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance=new SingletonService();

    public static SingletonService getInstance(){ //인스턴스 조회시 사용
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
