class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(num,target,0,0,0,"",ans);
        return ans;
    }

    private void solve(String num,long target,int index,long eval,long residual,String exp,List<String> ans){

        if(index == num.length()){
                if(eval == target){
                ans.add(exp);
            }
            return;
        }
        for(int i=index;i<num.length();i++){
            if(i > index && num.charAt(index)=='0'){
                break;
            }

            String part = num.substring(index,i+1);
            long curr= Long.parseLong(part);

            if(index==0){
                solve(num,target,i+1,curr,curr,part,ans);
            }else{

                solve(num,target,i+1,eval+curr,curr,exp+"+"+part,ans);
                solve(num,target,i+1,eval-curr,-curr,exp+"-"+part,ans);
                solve(num,target,i+1,eval-residual + residual*curr,residual*curr,exp+"*"+part,ans);
            }
        }
    }
} 