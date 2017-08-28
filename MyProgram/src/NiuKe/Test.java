package NiuKe;

public class Test{
    public static void main(String[] args){
        System.out.println(new Test().test());
    }
    public int test(){
        int res = 1;
        try{
            throw new Exception();
        }catch(Exception e){
            return res+1;
        }finally{
            res = 3;
            System.out.println("finally");
        }
    }
}