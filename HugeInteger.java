/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;
import java.util.Random;

/**
 *
 * @author Dominic
 */
public class HugeInteger {
    private int size;

    private int[] data;
    public HugeInteger(){
        
    }
    
    public HugeInteger(String val){
        int n = val.length();
        this.data = new int[n];
        int j=0;
        if((val.substring(0,1)).compareTo("-")==0){
            this.data[j]= -1;
            for (int i=1; i<n;i++){
                this.data[i]=Integer.parseInt(val.substring(i,i+1));
                
            }
        }
        else{
            for (int i=0; i<n;i++){
                this.data[i]=Integer.parseInt(val.substring(i,i+1));
                
            }
            
        }
        this.size=val.length();
    }
    public HugeInteger(int n){
        this.data = new int[n];
        Random rand = new Random();
        this.data[0]=rand.nextInt(9)+1;
        for(int i =1;i<n;i++){
            
            this.data[i]= rand.nextInt(9);
        }
        this.size=n;
    }
    public HugeInteger(int[] k){
        if (k[0]<0){
            //System.out.println("hi");
            int b=0;
            int j=1;
            int check=1;
            while(k[j]==0){
                if(j==k.length-1){
                    this.data = new int[1];
                    this.data[0]=0;
                    check =0;
                    
                    break;
                }
                b++;
                j++;
            }
            
            
            this.data = new int[k.length-b];
            if(check==1){
                this.data[0]=-1;
            }
            
            for(int i =1;i<k.length-b;i++){
                this.data[i]=k[i+b];
            }
            
        }
        else if(k[0]==0){
            //System.out.println("hi");
            int b=0;
            int j=0;
            while(k[j]==0){
                if(j==k.length-1){
                    this.data = new int[1];
                    this.data[0]=0;
                    break;
                }
                b++;
                j++;
            }
            
            
            this.data = new int[k.length-b];
            
            for(int i =0;i<k.length-b;i++){
                this.data[i]=k[i+b];
            }
            this.size=k.length;
        }
        else{
            //System.out.println("hi");
            this.data= new int[k.length];
            int j =0;
            for(int i =0;i<k.length;i++){
                this.data[j]=k[i];
                j++;
            }
        }
        
    }
    public HugeInteger(HugeInteger h){
        if (h.getElement(0)<0){
            //System.out.println("hi");
            int b=0;
            int j=1;
            int check=1;
            while(h.getElement(j)==0){
                if(j==h.getSize()-1){
                    this.data = new int[1];
                    this.data[0]=0;
                    check =0;
                    
                    break;
                }
                b++;
                j++;
            }
            
            
            this.data = new int[h.getSize()-b];
            if(check==1){
                this.data[0]=-1;
            }
            
            for(int i =1;i<h.getSize()-b;i++){
                this.data[i]=h.getElement(i+b);
            }
            
        }
        else if(h.getElement(0)==0){
            //System.out.println("hi");
            int b=0;
            int j=0;
            while(h.getElement(j)==0){
                if(j==h.getSize()-1){
                    this.data = new int[1];
                    this.data[0]=0;
                    break;
                }
                b++;
                j++;
            }
            
            
            this.data = new int[h.getSize()-b];
            
            for(int i =0;i<h.getSize()-b;i++){
                this.data[i]=h.getElement(i+b);
            }
        }
        else{
            //System.out.println("hi");
            this.data= new int[h.getSize()];
            int j =0;
            for(int i =0;i<h.getSize();i++){
                this.data[j]=h.getElement(i);
                j++;
            }
        }
        
        
    }
    public void printList(){
        for(int i =0;i<this.data.length;i++){
            System.out.println(this.data[i]);
        }
    }
    public int getSize(){
        return this.data.length;
    }
    public int getElement(int i){
        return this.data[i];
    }
    public int getInt(){
        int i;
        int k =0;
        int total =0;
        for(i=this.data.length-1;i>=0;i--){
            int temp =this.data[i];
            for (int j=0;j<k;j++){
                temp=temp*10;
                
            }
            k++;
            total = total +temp;
        }
        return total;
    }
    public void insert(int h, int index){
        this.data[index]= h;
    }
    
    public HugeInteger add(HugeInteger h){
        if ((this.data[0]>0)&&(h.getElement(0)>0)){
            
        
            if (this.data.length>h.getSize()){
                int[] k = new int[this.data.length+1];
                int b = this.data.length;
                int carry=0;
                int temp = this.data.length - h.getSize();
                int bound = h.getSize()-1;
                for(int i=this.data.length-1;i>=temp;i--){
                    k[b]= (this.data[i]+h.getElement(bound)+carry)%10;
                
                    carry = (this.data[i]+h.getElement(bound)+carry)/10;
                    bound--;
                    b--;
                
                }
                for(int i=temp-1;i>=0;i--){
                    k[b]=(this.data[i]+carry)%10;
                
                    carry = (this.data[i]+carry)/10;
                    b--;
                } 
           
                HugeInteger f = new HugeInteger(k);
                return f;
            
            }
            else if(h.getSize()>this.data.length){
                int[] k = new int[h.getSize()+1];
                int b = h.getSize();
                int carry =0;
                int temp = h.getSize()-this.data.length;
                int bound = this.data.length -1;
                for(int i = h.getSize()-1;i>=temp;i--){
                    k[b] = (h.getElement(i)+this.data[bound]+carry)%10;
                
                    carry = ((h.getElement(i)+this.data[bound]+carry) - (h.getElement(i)+this.data[bound]+carry)%10)/10;
                    bound--;
                    b--;
                }
                for(int i=temp-1;i>=0;i--){
                    k[b]=(h.getElement(i)+carry)%10;
                    carry = (h.getElement(i)+carry)/10;
                    b--;
                }
            
                HugeInteger f = new HugeInteger(k);
                return f;
            
            }
            else{
                int[] k = new int[this.data.length+1];
                int carry = 0;
                int b = this.data.length;
                for (int i = this.data.length-1;i>=0;i--){
                    k[b] = (this.data[i]+h.getElement(i)+carry)%10;
                    carry = (this.data[i]+h.getElement(i)+carry)/10;
                    b--;
                }
                if(carry==0){
                k[0]=0;
                }
                else{
                k[0]=1;
                }
                HugeInteger f = new HugeInteger(k);
                return f;
               
            }
        }
        else if((h.getElement(0)<0&&this.data[0]>0)||(h.getElement(0)>0&&this.data[0]<0)){//if one of the numbers is negative
            if(this.data.length>h.getSize()){
                if(h.getElement(0)<0){
                    int[] k = new int[this.data.length];
                    int b = this.data.length-1;
                    int temp = this.data.length - h.getSize();
                    int bound = h.getSize()-1;
                    int carry =0;
                    for (int i=this.data.length-1;i>temp;i--){
                        if ((this.data[i]-h.getElement(bound)-carry)<0){
                            
                            k[i]= (10+(this.data[i]-h.getElement(bound)-carry));
                            carry =1;
                            bound--;
                        }
                        else{
                            k[i] = (this.data[i]-h.getElement(bound)-carry);
                            carry =0;
                            bound--;
                        }
                        
                    }
                    for (int i=temp;i>=0;i--){
                        if ((this.data[i]-carry)<0){
                            k[i]= (10+(this.data[i]-carry));
                            carry =1;
                        }
                        else{
                            k[i]=(this.data[i]-carry);
                            carry=0;
                            
                        }
                        
                    }
                    HugeInteger f = new HugeInteger(k);
                    return f;
                    
                    
                    
                }
                else{
                    
                    
                    int[] k = new int[this.data.length];
                    int bound =h.getSize()-1;
                    int carry =0;
                    int temp = this.data.length-h.getSize();
                    for (int i=this.data.length-1;i>=temp;i--){
                        if(i==temp&&i!=1){
                            
                            
                            if(this.data[i]<h.getElement(bound)){
                                carry=1;
                                k[i]=10-Math.abs(this.data[i]-h.getElement(bound));
                            }
                            else{
                                k[i] = Math.abs(this.data[i]-h.getElement(bound));
                                
                                carry=0;
                            }
                            bound--;
                        }
                        else{
                            
                            k[i]=Math.abs(this.data[i]-h.getElement(bound));
                            bound--;
                            
                        }
                        
                    }
                    if (temp>1){
                        for (int i =temp-1;i>=1;i--){
                            if ((this.data[i]-carry)<0){
                                k[i]= Math.abs(this.data[i]-carry);
                                carry=1;
                            }
                            else{
                                k[i]=Math.abs(this.data[i]-carry);
                                carry=0;
                            }
                        }
                    }
                    else{
                        if(this.data[1]<h.getElement(0)){
                            carry=1;
                        }
                        else{
                            carry=0;
                        }
                    }
                    if(carry==1){
                        k[0]=0;
                    }
                    else{
                        k[0]=-1;
                    }
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                }
                
            }
            else if(h.getSize()>this.data.length){
                if(this.data[0]<0){
                    int[] k = new int[h.getSize()];
                    int bound =this.data.length-1;
                    int carry =0;
                    int temp = h.getSize() -this.data.length;
                    for (int i =(h.getSize()-1);i>temp;i--){
                        
                        if (h.getElement(i)-this.data[bound]-carry<0){
                            k[i] = 10 +(h.getElement(i)-this.data[bound]-carry);
                            bound--;
                            carry=1;
                        }
                        else{
                            k[i] = h.getElement(i)-this.data[bound]-carry;
                            bound--;
                            carry=0;
                        }
                    }
                    for (int i =temp;i>=0;i--){
                        if ((h.getElement(i)-carry)<0){
                            k[i] = 10 +(h.getElement(i)-carry);
                            carry=1;
                        }
                        else{
                            k[i] = h.getElement(i)-carry;
                            carry=0;
                        }
                    }
                    HugeInteger f = new HugeInteger(k);
                    return f;
                    
                }
                else{
                    
                    
                    int[] k = new int[h.getSize()];
                    int bound =this.data.length -1;
                    int carry =0;
                    int temp = h.getSize()-this.data.length;
                    for (int i=h.getSize()-1;i>=temp;i--){
                        if(i==temp&&i!=1){
                            
                            
                            if(this.data[bound]>h.getElement(i)){
                                carry=1;
                                k[i]=10-Math.abs(this.data[bound]-h.getElement(i));
                            }
                            else{
                                k[i] = Math.abs(this.data[bound]-h.getElement(i));
                                
                                carry=0;
                            }
                            bound--;
                        }
                        else{
                            
                            k[i]=Math.abs(this.data[bound]-h.getElement(i));
                            bound--;
                            
                        }
                        
                    }
                    if (temp>1){
                        for (int i =temp-1;i>=1;i--){
                            if ((h.getElement(i)-carry)<0){
                                k[i]= Math.abs(h.getElement(i)-carry);
                                carry=1;
                            }
                            else{
                                k[i]=Math.abs(h.getElement(i)-carry);
                                carry=0;
                            }
                        }
                    }
                    else{
                        if(this.data[0]>h.getElement(1)){
                            carry=1;
                        }
                        else{
                            carry=0;
                        }
                    }
                    if(carry==1){
                        k[0]=0;
                    }
                    else{
                        k[0]=-1;
                    }
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                }
            }
            else{
                
                int [] k =new int[this.data.length];
                int carry=0;
                if (this.data[0]<0){
                    for (int i=this.data.length-1;i>=1;i--){
                        if ((h.getElement(i)-this.data[i]-carry)<0){
                            k[i]= 10+(h.getElement(i)-this.data[i]-carry);
                            carry=1;
                        }
                        else{
                            k[i]=h.getElement(i)-this.data[i]-carry;
                            carry =0;
                        }
                    }
                    k[0]=h.getElement(0)-carry;
                }
                else{
                    for (int i=h.getSize()-1;i>=1;i--){
                        if ((this.data[i]-h.getElement(i)-carry)<0){
                            k[i]=10+(this.data[i]-h.getElement(i)-carry);
                            carry=1;
                        }
                        else{
                            k[i]= this.data[i]-h.getElement(i)-carry;
                            carry =0;
                        }
                        
                    }
                    k[0]=this.data[0]-carry;
                }
                HugeInteger f =new HugeInteger(k);
                return f;
                
                
            }
        }
        else{
            if (this.data.length>h.getSize()){
                int[] k = new int[this.data.length+1];
                int b = this.data.length;
                int carry=0;
                int temp = this.data.length - h.getSize();
                int bound = h.getSize()-1;
                for(int i=this.data.length-1;i>temp;i--){
                    k[b]= (this.data[i]+h.getElement(bound)+carry)%10;
                
                    carry = (this.data[i]+h.getElement(bound)+carry)/10;
                    bound--;
                    b--;
                
                }
                for(int i=temp;i>=1;i--){
                    k[b]=(this.data[i]+carry)%10;
                
                    carry = (this.data[i]+carry)/10;
                    b--;
                }
                if (carry==1){
                    k[1]=1;
                }
                else{
                    k[1]=0;
                }
                k[0]=-1;
                
           
                HugeInteger f = new HugeInteger(k);
                return f;
            
            }
            else if(h.getSize()>this.data.length){
                int[] k = new int[h.getSize()+1];
                int b = h.getSize();
                int carry =0;
                int temp = h.getSize()-this.data.length;
                int bound = this.data.length -1;
                for(int i = h.getSize()-1;i>temp;i--){
                    k[b] = (h.getElement(i)+this.data[bound]+carry)%10;
                
                    carry = (h.getElement(i)+this.data[bound]+carry)/10;
                    bound--;
                    b--;
                }
                for(int i=temp;i>=1;i--){
                    k[b]=(h.getElement(i)+carry)%10;
                    carry = (h.getElement(i)+carry)/10;
                    b--;
                }
                if (carry==1){
                    k[1]=1;
                }
                else{
                    k[1]=0;
                }
                k[0]=-1;
            
                HugeInteger f = new HugeInteger(k);
                return f;
            
            }
            else{
                int[] k = new int[this.data.length+1];
                int carry = 0;
                int b = this.data.length;
                for (int i = this.data.length-1;i>=1;i--){
                    k[b] = (this.data[i]+h.getElement(i)+carry)%10;
                    carry = (this.data[i]+h.getElement(i)+carry)/10;
                    b--;
                }
                if(carry==0){
                k[1]=0;
                }
                else{
                k[1]=1;
                }
                k[0]=-1;
                HugeInteger f = new HugeInteger(k);
                return f;
               
            }
            
        }
        
        
        
    }
    //public HugeInteger add2(HugeInteger h){
        
    //}
    public HugeInteger subtract(HugeInteger h){
        if ((this.data[0]>0)&&(h.getElement(0)>0)){
            if(this.data.length>h.getSize()){
                
                //System.out.println("hi");
                    
                    
                    int[] k = new int[this.data.length];
                    int bound =h.getSize()-1;
                    int carry =0;
                    int temp = this.data.length-h.getSize();
                    for (int i=this.data.length-1;i>=temp;i--){
                        
                        if(bound>=0){
                            
                            if(h.getElement(bound)>this.data[i]){
                                
                                k[i]=10-Math.abs(this.data[i]-h.getElement(bound));
                                carry=1;
                                bound--;
                            }
                            else if(h.getElement(bound)==this.data[i]){
                                
                                if(carry==1){
                                    
                                    k[i]=10-Math.abs(this.data[i]-h.getElement(bound));
                                    carry=1;
                                    bound--;
                                }
                                else{
                                    k[i]=Math.abs(this.data[i]-h.getElement(bound));
                                    carry=0;
                                    bound--;
                                }
                            }
                            else{
                                
                                k[i]=Math.abs(this.data[i]-h.getElement(bound));
                                bound--;
                                carry=0;
                            }
                        }   
                        
                        
                        
                    }
                    for (int i =temp-1;i>=0;i--){
                            if ((this.data[i]-carry)<0){
                                k[i]= 10-Math.abs(this.data[i]-carry);
                                carry=1;
                            }
                            else{
                                k[i]=Math.abs(this.data[i]-carry);
                                carry=0;
                            }
                    }
                    
                    
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                
                
            }
            else if(h.getSize()>this.data.length){
                
                
                    
                    
                    int[] k = new int[h.getSize()+1];
                    int bound =this.data.length -1;
                    int carry =0;
                    int temp = h.getSize()-this.data.length;
                    int bound2 = h.getSize();
                    
                    for (int i=h.getSize()-1;i>=temp;i--){
                        
                        //else{
                            //System.out.println("hi");
                            if(h.getElement(i)<this.data[bound]){
                                
                                k[bound2]= 10 -Math.abs(h.getElement(i)-this.data[bound]-carry);
                                carry=1;
                                bound--;
                                bound2--;
                            }
                            else{
                                
                                k[bound2]=Math.abs(this.data[bound]-h.getElement(i)+carry);
                                bound--;
                                bound2--;
                                carry=0;
                            }
                        //}
                        
                        
                    }
                    if(temp>1){
                        //System.out.println("hi");
                        for (int i =temp-1;i>=0;i--){
                            if ((h.getElement(i)-carry)<0){
                                k[bound2]=10- Math.abs(h.getElement(i)-carry);
                                carry=1;
                                bound2--;
                            }
                            else{
                                k[bound2]=Math.abs(h.getElement(i)-carry);
                                carry=0;
                                bound2--;
                            }
                        }
                    }
                    
                    k[0]=-1;
                    
                    
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                
            }
            else{
                
                int [] k =new int[this.data.length+1];
                int carry=0;
                int bound =this.data.length;
                
                if(this.data[0]>h.getElement(0)){
                    for (int i=h.getSize()-1;i>=0;i--){
                        if(i==0){
                            if ((this.data[i]-h.getElement(i)-carry)<0){
                                
                                
                                k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                                carry =1;
                            }
                            else{
                                
                                
                                k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                                carry=0;
                            }
                            
                            
                        }
                        
                        else if ((this.data[i]-h.getElement(i)-carry)<0){
                            k[bound]=10-Math.abs(this.data[i]-h.getElement(i)-carry);
                            carry=1;
                            
                        }
                        else{
                            k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                            carry =0;
                        }
                        bound--;
                        
                    }
                    if(carry==1){
                        k[0]=-1;
                    }
                    else{
                        k[0]=0;
                    }
                }
                else{
                    for (int i=h.getSize()-1;i>=0;i--){
                        if(i==0){
                            if ((this.data[i]-h.getElement(i)-carry)<0){
                                carry =1;
                                k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            }
                            else{
                                carry=0;
                                k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            }
                            
                            
                        }
                        
                        else if ((this.data[i]-h.getElement(i)-carry)<0){
                            k[bound]=Math.abs(this.data[i]-h.getElement(i));
                            carry=1;
                            
                        }
                        else{
                            k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            carry =0;
                        }
                        bound--;
                        
                    }
                    if(carry==1){
                        k[0]=-1;
                    }
                    else{
                        k[0]=0;
                    }
                    
                }
                HugeInteger f =new HugeInteger(k);
                return f;
                
                
            }
            
        }
        else if((h.getElement(0)<0&&this.data[0]>=0)||(h.getElement(0)>=0&&this.data[0]<0)){
           
            if(this.data[0]>=0){
                if (this.data.length>h.getSize()){
                    int[] k = new int[this.data.length+1];
                    int b = this.data.length;
                    int carry=0;
                    int temp = this.data.length - h.getSize();
                    int bound = h.getSize()-1;
                    for(int i=this.data.length-1;i>temp;i--){
                        k[b]= (this.data[i]+h.getElement(bound)+carry)%10;
                
                        carry = (this.data[i]+h.getElement(bound)+carry)/10;
                        bound--;
                        b--;
                
                    }
                    
                    for(int i=temp;i>=0;i--){
                        
                        k[b]=(this.data[i]+carry)%10;
                
                        carry = (this.data[i]+carry)/10;
                        b--;
                    } 
           
                    HugeInteger f = new HugeInteger(k);
                    return f;
                }
                else if(h.getSize()>this.data.length){
                    
                    int[] k = new int[h.getSize()+1];
                    int b = h.getSize();
                    int carry =0;
                    int temp = h.getSize()-this.data.length;
                    int bound = this.data.length -1;
                    for(int i = h.getSize()-1;i>=temp;i--){
                        k[b] = (h.getElement(i)+this.data[bound]+carry)%10;
                
                        carry = ((h.getElement(i)+this.data[bound]+carry) - (h.getElement(i)+this.data[bound]+carry)%10)/10;
                        bound--;
                        b--;
                    }
                    for(int i=temp-1;i>=1;i--){
                        k[b]=(h.getElement(i)+carry)%10;
                        carry = (h.getElement(i)+carry)/10;
                        b--;
                    }
                    k[0]=0;
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
            
                }
                else{
                    int[] k = new int[this.data.length+1];
                    int carry = 0;
                    int b = this.data.length;
                    //int bound =this.data.length-1;
                    for (int i = this.data.length-1;i>=1;i--){
                        k[b] = (this.data[i]+h.getElement(i)+carry)%10;
                        carry = (this.data[i]+h.getElement(i)+carry)/10;
                        b--;
                    }
                    k[b]=(this.data[0]+carry)%10;
                    carry = (this.data[0]+carry)/10;
                    if(carry==0){
                    k[0]=0;
                    }
                    else{
                    k[0]=1;
                    }
                    HugeInteger f = new HugeInteger(k);
                    return f;
               
                }
            
            }
        
            else{
                //System.out.println("hi");
                if (this.data.length>h.getSize()){
                    int[] k = new int[this.data.length+1];
                    int b = this.data.length;
                    int carry=0;
                    int temp = this.data.length - h.getSize();
                    int bound = h.getSize()-1;
                    for(int i=this.data.length-1;i>=temp;i--){
                        if(i>=1){
                        
                            k[b]= (this.data[i]+h.getElement(bound)+carry)%10;
                
                            carry = (this.data[i]+h.getElement(bound)+carry)/10;
                            bound--;
                            b--;
                        }
                        
                
                    }
                    if(temp>1){
                        for(int i=temp-1;i>=1;i--){
                            k[b]=(this.data[i]+carry)%10;
                
                            carry = (this.data[i]+carry)/10;
                            b--;
                        }
                    }
                    if (carry==1){
                        k[1]=1;
                    }
                    else{
                        k[1]=0;
                    }
                    
                    k[0]=-1;
                
           
                    HugeInteger f = new HugeInteger(k);
                    return f;
            
                }
                else if(h.getSize()>this.data.length){
                    //System.out.println("hi");
                    int[] k = new int[h.getSize()+2];
                    int b = h.getSize()+1;
                    int carry =0;
                    int temp = h.getSize()-this.data.length;
                    int bound = this.data.length -1;
                    for(int i = h.getSize()-1;i>temp;i--){
                    
                        k[b] = (h.getElement(i)+this.data[bound]+carry)%10;
                
                        carry = (h.getElement(i)+this.data[bound]+carry)/10;
                        bound--;
                        b--;
                    }
                    
                    for(int i=temp;i>=0;i--){
                        k[b]=(h.getElement(i)+carry)%10;
                        carry = (h.getElement(i)+carry)/10;
                        b--;
                    }
                    
                    if (carry==1){
                        k[1]=1;
                    }
                    else{
                        k[1]=0;
                    }
                    
                    k[0]=-1;
            
                    HugeInteger f = new HugeInteger(k);
                    return f;
            
                }
                else{
                    int[] k = new int[this.data.length+1];
                    int carry = 0;
                    int b = this.data.length;
                    for (int i = this.data.length-1;i>=1;i--){
                        k[b] = (this.data[i]+h.getElement(i)+carry)%10;
                        carry = (this.data[i]+h.getElement(i)+carry)/10;
                        b--;
                    }
                    if(carry==0){
                    k[1]=0;
                    }
                    else{
                    k[1]=1;
                    }
                    
                    k[0]=-1;
                    HugeInteger f = new HugeInteger(k);
                    return f;
               
                }
            
            }
        }
        else{
            if(this.data.length>h.getSize()){
                
                
                    
                    
                    int[] k = new int[this.data.length];
                    int bound =h.getSize()-1;
                    int carry =0;
                    int temp = this.data.length-h.getSize();
                    for (int i=this.data.length-1;i>=temp;i--){
                        if(i==temp){
                            
                            
                            if(this.data[i]==carry){
                                System.out.println("hi");
                                
                                k[i]=Math.abs(this.data[i]-carry);
                                carry=1;
                            }
                            else{
                                //System.out.println(h.getElement(bound));
                                k[i] = Math.abs(this.data[i]-carry);
                                
                                carry=0;
                            }
                            
                        }
                        else{
                            if(h.getElement(bound)+carry>this.data[i]){
                                k[i]=10-Math.abs(this.data[i]-h.getElement(bound)-carry);
                                carry=1;
                                bound--;
                            }
                            else{
                                k[i]=Math.abs(this.data[i]-h.getElement(bound)-carry);
                                bound--;
                                carry=0;
                            }
                            
                        }
                        
                        
                    }
                    if(temp>1){
                        for (int i =temp-1;i>=1;i--){
                            if ((this.data[i]-carry)<0){
                                k[i]= Math.abs(this.data[i]-carry);
                                carry=1;
                            }
                            else{
                                k[i]=Math.abs(this.data[i]-carry);
                                carry=0;
                            }
                        }
                    }
                    k[0]=-1;
                    
                    
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                
                
            }
            else if(h.getSize()>this.data.length){
                
                //System.out.println("hi");
                    
                    int[] k = new int[h.getSize()];
                    int bound =this.data.length-1;
                    int carry =0;
                    int temp = h.getSize()-this.data.length;
                    for (int i=h.getSize()-1;i>=temp;i--){
                        //System.out.println("hi");
                        if(i==temp){
                            
                            
                            if(h.getElement(i)<carry){
                                
                                
                                k[i]=10-Math.abs(h.getElement(i)-carry);
                                carry=1;
                            }
                            else{
                                //System.out.println(h.getElement(bound));
                                k[i] = Math.abs(h.getElement(i)-carry);
                                
                                carry=0;
                            }
                            
                        }
                        else{
                            if(h.getElement(i)<this.data[bound]){
                                k[i]=10-Math.abs(this.data[bound]-h.getElement(i)-carry);
                                carry=1;
                                bound--;
                            }
                            else if(h.getElement(i)==this.data[bound]){
                                if (carry==1){
                                    
                                    k[i]=10-Math.abs(this.data[bound]-h.getElement(i)-carry);
                                    carry=1;
                                    bound--;
                                    
                                }
                                else{
                                    k[i]=0;
                                    carry=0;
                                    bound--;
                                }
                            }
                            else{
                                k[i]=Math.abs(this.data[bound]-h.getElement(i)+carry);
                                bound--;
                                carry=0;
                            }
                            
                        }
                        
                        
                    }
                    if(temp>1){
                        for (int i =temp-1;i>=1;i--){
                            if ((h.getElement(i)-carry)<0){
                                k[i]= 10-Math.abs(h.getElement(i)-carry);
                                carry=1;
                            }
                            else{
                                k[i]=Math.abs(h.getElement(i)-carry);
                                carry=0;
                            }
                        }
                    }
                    k[0]=0;
                    
                    
                    
                    HugeInteger f = new HugeInteger(k);
                    return f;
                
            }
            else{
                
                int [] k =new int[this.data.length+1];
                int carry=0;
                int bound =this.data.length;
                
                if(this.data[0]>h.getElement(0)){
                    for (int i=h.getSize()-1;i>=0;i--){
                        if(i==0){
                            if ((this.data[i]-h.getElement(i)-carry)<0){
                                
                                
                                k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                                carry =1;
                            }
                            else{
                                
                                
                                k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                                carry=0;
                            }
                            
                            
                        }
                        
                        else if ((this.data[i]-h.getElement(i)-carry)<0){
                            k[bound]=10-Math.abs(this.data[i]-h.getElement(i)-carry);
                            carry=1;
                            
                        }
                        else{
                            k[bound]= Math.abs(this.data[i]-h.getElement(i)-carry);
                            carry =0;
                        }
                        bound--;
                        
                    }
                    if(carry==0){
                        k[0]=-1;
                    }
                    else{
                        k[0]=0;
                    }
                }
                else{
                    for (int i=h.getSize()-1;i>=0;i--){
                        if(i==0){
                            if ((this.data[i]-h.getElement(i)-carry)<0){
                                carry =1;
                                k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            }
                            else{
                                carry=0;
                                k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            }
                            
                            
                        }
                        
                        else if ((this.data[i]-h.getElement(i)-carry)<0){
                            k[bound]=Math.abs(this.data[i]-h.getElement(i));
                            carry=1;
                            
                        }
                        else{
                            k[bound]= Math.abs(this.data[i]-h.getElement(i));
                            carry =0;
                        }
                        bound--;
                        
                    }
                    if(carry==0){
                        k[0]=-1;
                    }
                    else{
                        k[0]=0;
                    }
                    
                }
                HugeInteger f =new HugeInteger(k);
                return f;
                
                
            }
        }
        
    }
    public HugeInteger multiply(HugeInteger h){
        
        HugeInteger multiply= new HugeInteger();
        multiply.size=this.data.length+h.getSize();
        multiply.data=new int[multiply.size];
        int i=this.getSize()-1; 
        int j=h.getSize()-1; 
        int k=multiply.getSize()-1;
        int carry=0,value=0;
        int temp = Math.abs(this.data.length-h.getSize());
        if(this.data[0]>0&&h.getElement(0)>0){   
            for(int counter2=0;counter2<=j;counter2++){
                for(int counter=0;counter<=i;counter++){
                    value=((h.getElement(j-counter2))*(this.data[i-counter]));                
                    multiply.data[k-counter-counter2]+=(value);
                    carry= multiply.data[k-counter-counter2]/10;               
                multiply.data[k-counter-counter2]%=10;  
                multiply.data[k-counter-counter2-1]+=carry;
                }
            }
                multiply.data[0]=carry;
        }
        else if (this.data[0]==-1&&h.getElement(0)==-1){
            for(int counter2=0;counter2<j;counter2++){
                for(int counter=0;counter<i;counter++){
                    value=((h.getElement(j-counter2))*(this.data[i-counter]));                
                    multiply.data[k-counter-counter2]+=(value);
                    carry= multiply.data[k-counter-counter2]/10;               
                multiply.data[k-counter-counter2]%=10;  
                multiply.data[k-counter-counter2-1]+=carry;
                }
            }
            multiply.data[0]=0;
            multiply.data[1]=0;
            multiply.data[2]=carry;
        }
        
        else if (this.data[0]==-1){
            for(int counter2=0;counter2<=j;counter2++){
                for(int counter=0;counter<i;counter++){
                    value=((h.getElement(j-counter2))*(this.data[i-counter]));                
                    multiply.data[k-counter-counter2]+=(value);
                    carry= multiply.data[k-counter-counter2]/10;               
                multiply.data[k-counter-counter2]%=10;  
                multiply.data[k-counter-counter2-1]+=carry;
                }
            }
                multiply.data[1]=carry;
                multiply.data[0]=-1;
        }
        else{
            for(int counter2=0;counter2<j;counter2++){
                for(int counter=0;counter<=i;counter++){
                    value=((h.getElement(j-counter2))*(this.data[i-counter]));                
                    multiply.data[k-counter-counter2]+=(value);
                    carry= multiply.data[k-counter-counter2]/10;               
                multiply.data[k-counter-counter2]%=10;  
                multiply.data[k-counter-counter2-1]+=carry;
                }
            }
                multiply.data[1]=carry;
                multiply.data[0]=-1;
            
        }
        multiply.size=multiply.data.length;
        HugeInteger total = new HugeInteger(multiply.data);
        return total;
    }
    public String toString(){
        String s ="";
        for (int i=0;i<this.getSize();i++){
            s=s+Integer.toString(this.getElement(i));
        }
        return s;
        
    }
    public int compareTo(HugeInteger h){
        if(this.data[0]>0&&h.getElement(0)>0){
            if (this.data.length>h.getSize()){
                return 1;
            }
            else if(h.getSize()>this.data.length){
                return -1;
            }
            
            else{
                int check =1;
                int j=0;
                while(this.data[j]==h.getElement(j)){
                    j++;
                    check=0;
                }
                if(check==0){
                    return 0;
                }
                else if(this.data[0]>h.getElement(0)){
                    return 1;
                }
                else{
                    return -1;
                }
            
            }
          
        }
        else if((h.getElement(0)<0&&this.data[0]>=0)||(h.getElement(0)>=0&&this.data[0]<0)){
            if(this.data[0]<0){
                return -1;
            }
            else{
                return 1;
            }
        }
        else{
            if(this.data.length>h.getSize()){
                return -1;
            }
            else if(h.getSize()>this.data.length){
                return 1;
            }
            else{
                int check =1;
                int j=1;
                while(this.data[j]==h.getElement(j)){
                    if(j==this.data.length-1){
                        break;
                    }
                    j++;
                    check=0;
                }
                if(check==0){
                    return 0;
                }
                else if(this.data[1]>h.getElement(1)){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }
    }
}




    
    
    

