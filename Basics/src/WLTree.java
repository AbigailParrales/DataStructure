import java.util.Arrays;

public class WLTree {
	private WLTNode root;
	int[] keys;
	int[]s0,s1,s2,s3;
	
	class WLTNode{
		int key;
		WLTNode right,left;

		public WLTNode(int key) {
			this.key=key;
		}
	}
	
	public WLTree(int[] rKeys) {
		int factor=(this.keys.length+1)/4;
		this.keys=rKeys;
		
		if(this.keys.length+1<4) {		//
			
		}
		else{
			s0= new int[(this.keys.length+1)/4];
			s1= new int[(this.keys.length+1)/4];
			s2= new int[(this.keys.length+1)/4];
			s3= new int[(this.keys.length+1)/4];
			
			System.arraycopy(this.keys, 0, s0, 0, (this.keys.length+1)/4);

		}
		
		
	}
	
	public static void Main(String[] args) {
		System.out.println("Estoy en el main");
		int[] keys= {1,2,3,4,5,6,7,8,9,10};
		WLTree wt = new WLTree(keys);

		int []s0= new int[(keys.length+1)/4];
		
		s0= new int[(keys.length+1)/4];
		System.out.println(Arrays.toString(keys));
		System.out.println(Arrays.toString(s0));
	}
	

}
