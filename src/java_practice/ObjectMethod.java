package java_practice;

public class ObjectMethod {
	public static class ReferenceValue{
		int num = 0;
		ReferenceValue(int num){
			this.num = num;
		}


		@Override
		public boolean equals(Object obj){
			if(obj instanceof ReferenceValue){
				return num == ((ReferenceValue)obj).num;
			}else{
				return false;
			}
		}
	}

	public static void main(String[] args) {

		ReferenceValue compare1 = new ReferenceValue(10);
		ReferenceValue compare2 = new ReferenceValue(10);
	}

}
