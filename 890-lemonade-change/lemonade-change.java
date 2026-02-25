class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollar=0;
        int tenDollar=0;
        for(int customerBill : bills){
            if(customerBill == 5){
                fiveDollar++;
            } else if(customerBill == 10){
                if(fiveDollar>0){
                    fiveDollar--;
                    tenDollar++;
                } else{
                    return false;
                }
            } else{
                if(tenDollar > 0 && fiveDollar > 0){
                    fiveDollar--;
                    tenDollar--;
                } else if(fiveDollar >= 3){
                    fiveDollar -=3;
                } else{ // can't provide change return false 
                    return false;
                }
            }
        }
        return true;
    }
}