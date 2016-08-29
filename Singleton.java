package subject1;

/**
 * <p>Description:设计一个类，我们只能生成该类的一个实例 </p>
 *
 * @author:欧一宏
 * @date:2016/8/29 23:47
 * @version:1.0
 */
public class Singleton {

	/**
	 * 单例模式，懒汉式，线程安全
	 */
	public static class Singleton1{
		private static Singleton1 INSTANCE=new Singleton1();
		public Singleton1(){

		}
		public static Singleton1 getInstance(){
			return INSTANCE;
		}
	}
	/**
	 * 单例模式，饿汉式，线程不安全
	 */
	public static class Singleton2{
		private static Singleton2 INSTANCE;
		public Singleton2(){

		}
		public static Singleton2 getInstance(){
			if (INSTANCE==null)
			INSTANCE=new Singleton2();
			return INSTANCE;
		}
	}
	/**
	 *单例模式，饿汉式，线程安全,多线程下效率不高
	 */
	public static class Singleton3{
		private static Singleton3 INSTANCE;
		public Singleton3(){

		}
		public static synchronized Singleton3 getInstance(){
			if (INSTANCE==null)
				INSTANCE=new Singleton3();
			return INSTANCE;
		}
	}
	/**
	 * 单例模式，懒汉式，线程安全
	 */
	public static class Singleton4{
		private static Singleton4 INSTANCE=null;
		static{
			INSTANCE=new Singleton4();
		}
		public Singleton4(){

		}
		public static synchronized Singleton4 getInstance(){
			return INSTANCE;
		}
	}
	/**
	 * 单例模式，使用静态内部类，线程安全（推荐）
	 */
	//public static class Singleton5{
	//	private static final SingletonHolder{
	//		private static final Singleton5 INSTANCE=new Singleton5();
	//	}
	//	public Singleton5(){
	//
	//	}
	//	public static Singleton5 getInstance(){
	//		return SingletonHolder.INSTANCE;
	//	}
	//}
	/**
	 * 静态内部类，枚举方式,线程安全
	 */
	public enum  Singleton6{
		INSTANCE;
		public void getInstance(){

		}
	}
	/**
	 * 静态内部类，使用双重校验锁，线程安全
	 */
	public static class Singleton7{
		private volatile static Singleton7 INSTANCE=null;
		public Singleton7(){

		}
		public static Singleton7 getInstance(){
			if (INSTANCE==null){
				synchronized(Singleton7.class){
					if (INSTANCE==null){
						INSTANCE=new Singleton7();
					}
				}
			}
			return INSTANCE;
		}
	}

	public static void main(String[] args) {
		System.out.println(Singleton1.getInstance()==Singleton1.getInstance());
		System.out.println(Singleton2.getInstance()==Singleton2.getInstance());
		System.out.println(Singleton3.getInstance()==Singleton3.getInstance());
		System.out.println(Singleton4.getInstance()==Singleton4.getInstance());
		//System.out.println(Singleton5.getInstance()==Singleton5.getInstance());
		System.out.println(Singleton6.INSTANCE==Singleton6.INSTANCE);
		System.out.println(Singleton7.getInstance()==Singleton7.getInstance());


	}
}
