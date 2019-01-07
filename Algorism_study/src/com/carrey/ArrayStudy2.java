package com.carrey;

public class ArrayStudy2 {
	public String solution(int[] numbers) {
        String answer = "";
        quickSort(numbers,0,numbers.length-1);
       /* for(int i=0;i<numbers.length;i++) {
        	boolean exchange=false;
        	for(int j=i+1;j<numbers.length;j++) {
        		int x=getFirstNumber(numbers[i]);
        		int y=getFirstNumber(numbers[j]);
        		if(x==y) {	
        			int a=numbers[i];
        			int b=numbers[j];
        			
        			while(true) {
        				if(a<9 && b<9) break;
        				if(a>9) {
        					a=Integer.parseInt(String.valueOf(a).substring(1));
        				}
        				if(b>9) {
        					b=Integer.parseInt(String.valueOf(b).substring(1));
        				}
        				if(getFirstNumber(a)<getFirstNumber(b)) {
        					int temp=numbers[i];
                			numbers[i]=numbers[j];
                			numbers[j]=temp;
                			i--;
                			exchange=true;
                			break;
        				}  				
        			}
        			if(exchange) break;
        		}else if(x<y) {
        			int temp=numbers[i];
        			numbers[i]=numbers[j];
        			numbers[j]=temp;
        			i--;
        			break;
        		}
        	}
        }*/
        
        for(int i=0;i<numbers.length;i++) {
        	answer+=numbers[i]+"";
        }
        if(answer.startsWith("0")) answer="0";
        return answer;
    }
	
	public int getFirstNumber(int a) {
		return Integer.parseInt(String.valueOf((a+"").charAt(0)));
	}
	
	public int getNextNumber(int a) {
		return Integer.parseInt(String.valueOf((a+"").substring(0)));
	}
	
	public void quickSort(int a[],int l, int r) {
		int left = l;
		int right = r;
		int pivot = a[(l+r)/2];
		do {
			while(getFirstNumber(a[left])>=getFirstNumber(pivot)) {
				if(getFirstNumber(a[left])==getFirstNumber(pivot)) {
					int x=a[left];
					int y=pivot;
					while(true) {
						
						if(x>9) x=Integer.parseInt(String.valueOf(x).substring(1));
						if(y>9) y=Integer.parseInt(String.valueOf(y).substring(1));
						if(getFirstNumber(x)==getFirstNumber(y)) {
							
						}
						if(getFirstNumber(x)>getFirstNumber(y)) {
							left++;
							break;
						}
						if(x<10 && y<10) break;
					}
					break;
				}else {
					left++;
				}
			}
			while(getFirstNumber(a[right])<=getFirstNumber(pivot)) {
				if(getFirstNumber(a[right])==getFirstNumber(pivot)) {
					int x=a[right];
					int y=pivot;
					while(true) {
						
						if(x>9) x=Integer.parseInt(String.valueOf(x).substring(1));
						if(y>9) y=Integer.parseInt(String.valueOf(y).substring(1));
						if(getFirstNumber(x)<getFirstNumber(y)) {
							right--;
							break;
						}
						if(x<10 && y<10) break;
					}
					break;
				}else {
					right--;
				}
			}
			if(left<=right) {
				int temp=a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right--;
			}
		}while(left<=right);
		
		if(l<right) quickSort(a,l,right);
		if(r>left) quickSort(a,left,r);
	}
	public static void main(String args[]) {
		ArrayStudy2 arrayStudy2=new ArrayStudy2();
		int numbers[]= {20,200,20};
		System.out.println(arrayStudy2.solution(numbers));
	}
}
