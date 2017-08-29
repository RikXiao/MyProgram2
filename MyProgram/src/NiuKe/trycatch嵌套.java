package NiuKe;


 
class trycatch嵌套{
	class in {}
	public void bar(){
		new in();
	}
	public static void main(String[] args) {
		
		try {
			try {
				System.out.println(1);
				throw new Exception();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(2);
				throw e;
			}
			finally{
				System.out.println("neibu");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(3);
			
		}
		finally{
			System.out.println("sss");
		}
	}
}