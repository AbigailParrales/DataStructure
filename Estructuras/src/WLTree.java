import java.util.Arrays;

public class WLTree {
	private WLTNode l0,l1,l2,l3,w1,w2,wr;
	int[] keys;
	int[]s0,s1,s2,s3;

	class WLTNode{
		int key;
		WLTNode brother;
		String origin;

		public WLTNode(int key) {
			this.key=key;
		}

		public String toString() {
			return "["+this.key+"-"+this.brother.key+"]";
		}
	}

	public WLTree(int[] rKeys) {
		Heap h0,h1,h2,h3=null;
		this.keys=rKeys;
		int factor=((this.keys.length)/4)+1;


		if(this.keys.length<4) {		//
			s0= new int[2];
			s1= new int[2];
			s2= new int[2];
			s3= new int[2];

			if(this.keys.length==1) {
				s0[0]=keys[0];
			}
			if(this.keys.length==2) {
				s0[0]=keys[0];
				s1[1]=keys[1];
			}
			if(this.keys.length==3) {
				s0[0]=keys[0];
				s1[1]=keys[1];
				s2[2]=keys[2];
			}
		}
		else{
			s0= new int[factor];
			s1= new int[factor];
			s2= new int[factor];
			s3= new int[factor];

			System.arraycopy(keys, 0, s0, 0, ((keys.length)/4));
			System.arraycopy(keys, ((keys.length)/4), s1, 0, ((keys.length)/4));
			System.arraycopy(keys, ((keys.length)/4)*2, s2, 0, ((keys.length)/4));
			System.arraycopy(keys, ((keys.length)/4)*3, s3, 0, ((keys.length)/4));

			int residuo = (keys.length)%4;
			if(residuo==1) {
				s0[((keys.length)/4)]=keys[((keys.length)/4)*4];
			}
			if(residuo==2) {
				s0[((keys.length)/4)]=keys[((keys.length)/4)*4];
				s1[((keys.length)/4)]=keys[((keys.length)/4)*4+1];
			}
			if(residuo==3) {
				s0[((keys.length)/4)]=keys[((keys.length)/4)*4];
				s1[((keys.length)/4)]=keys[((keys.length)/4)*4+1];
				s2[((keys.length)/4)]=keys[((keys.length)/4)*4+2];
			}

			h0= new Heap(s0);
			h1= new Heap(s1);
			h2= new Heap(s2);
			h3= new Heap(s3);

			h0.HeapSort();
			h1.HeapSort();
			h2.HeapSort();
			h3.HeapSort();


			if(residuo==0) {
				System.arraycopy(h0.getA(), 1, s0, 0, factor);
				System.arraycopy(h1.getA(), 1, s1, 0, factor);
				System.arraycopy(h2.getA(), 1, s2, 0, factor);
				System.arraycopy(h3.getA(), 1, s3, 0, factor);
			}
			if(residuo==1) {
				System.arraycopy(h0.getA(), 1, s0, 0, factor);

				System.arraycopy(h1.getA(), 2, s1, 0, factor-1);
				System.arraycopy(h2.getA(), 2, s2, 0, factor-1);
				System.arraycopy(h3.getA(), 2, s3, 0, factor-1);
			}
			if(residuo==2) {
				System.arraycopy(h0.getA(), 1, s0, 0, factor);
				System.arraycopy(h1.getA(), 1, s1, 0, factor);

				System.arraycopy(h2.getA(), 2, s2, 0, factor-1);
				System.arraycopy(h3.getA(), 2, s3, 0, factor-1);
			}
			if(residuo==3) {
				System.arraycopy(h0.getA(), 1, s0, 0, factor);
				System.arraycopy(h1.getA(), 1, s1, 0, factor);
				System.arraycopy(h2.getA(), 1, s2, 0, factor);

				System.arraycopy(h3.getA(), 2, s3, 0, factor-1);
			}


		}

	}

	public void compete() {
		this.l0= new WLTNode(s0[0]);
		this.l1= new WLTNode(s1[0]);
		this.l2= new WLTNode(s2[0]);
		this.l3= new WLTNode(s3[0]);

		this.l0.origin="s0";
		this.l1.origin="s1";
		this.l2.origin="s2";
		this.l3.origin="s3";

		//Setting w1
		this.l0.brother=l1;
		this.l1.brother=l0;
		if(this.l0.key>this.l0.brother.key) {
			w1=this.l0.brother;
		}
		else if(this.l0.key<this.l0.brother.key) {
			w1=this.l0;
		}


		//Setting w2
		this.l2.brother=l3;
		this.l3.brother=l2;
		if(this.l2.key>this.l2.brother.key) {
			w2=this.l2.brother;
		}
		else if(this.l2.key<this.l2.brother.key) {
			w2=this.l2;
		}

		//Setting wr
		this.w1.brother=w2;
		this.w2.brother=w1;
		if(this.w1.key>this.w1.brother.key) {
			wr=this.w1.brother;
			wr.brother.key=0;
		}
		else if(this.w1.key<this.w1.brother.key) {
			wr=this.w1;
			wr.brother.key=0;
		}
	}

	public boolean delete() {
		int factor=((this.keys.length)/4)+1;
		int residuo = (keys.length)%4;

		int[] s0_tmp= s0;
		int[] s1_tmp= s1;
		int[] s2_tmp= s2;
		int[] s3_tmp= s3;

		int[] last=new int[residuo];

		System.out.println(this.wr.key);

		if((this.s0[1]==0)&&(this.s1[1]==0)&&(this.s2[1]==0)&&(this.s3[1]==0)) {
			if(residuo==0) {
				System.arraycopy(s0, 0, last, 0, residuo);
				System.arraycopy(s1, 0, last, 1, residuo-1);
				System.arraycopy(s2, 0, last, 2, residuo-2);
				System.arraycopy(s3, 0, last, 3, residuo-3);
			}
			if(residuo==1) {
				System.arraycopy(s0, 0, last, 0, residuo);
			}
			if(residuo==2) {
				System.arraycopy(s0, 0, last, 0, residuo);
				System.arraycopy(s1, 0, last, 1, residuo-1);
			}
			if(residuo==3) {
				System.arraycopy(s0, 0, last, 0, residuo);
				System.arraycopy(s1, 0, last, 1, residuo-1);
				System.arraycopy(s2, 0, last, 2, residuo-2);
			}
			Heap h= new Heap(last);
			h.HeapSort();
			System.arraycopy(h.getA(), 1, last, 0, residuo);
			for(int i=0;i<residuo;i++) {
				System.out.println(last[i]);
			}
			return false;
		}
		else {
			if(this.wr.origin.equals("s0")) {
				System.arraycopy(s0_tmp, 1, s0, 0, factor-1);
				s0[factor-1]=0;
			}
			if(this.wr.origin.equals("s1")) {
				System.arraycopy(s1_tmp, 1, s1, 0, factor-1);
				s1[factor-1]=0;
			}
			if(this.wr.origin.equals("s2")) {
				System.arraycopy(s2_tmp, 1, s2, 0, factor-1);
				s2[factor-1]=0;
			}
			if(this.wr.origin.equals("s3")) {
				System.arraycopy(s3_tmp, 1, s3, 0, factor-1);
				s3[factor-1]=0;
			}
		}

		return true;
	}

	public int getWinner() {
		return this.wr.key;
	}


	public static void main(String[] args) {
		int[] keys= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		boolean end=true;
		WLTree wt = new WLTree(keys);
		while(end) {
			wt.compete();
			wt.getWinner();
			end=wt.delete();
		}
	}
}
