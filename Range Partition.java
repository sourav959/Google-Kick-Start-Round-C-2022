import java.util.*;

class Solution{
    static List<Integer> solve(int n,int x,int y){
        List<Integer> ans=new ArrayList<>();
        long alan=0,bar=0;
        double r1=(double) x/y;
        long sum=0;
        for(int i=1;i<=n;i++)
            sum+=i;
        for(int i=1;i<=Math.pow(2,n)-1;i++){
            ans=new ArrayList<>();
            String bin=Integer.toBinaryString(i);
            alan=0;
            bar=0;
            int extra=n;
            for(int j=bin.length()-1;j>=0;j--){
                if(bin.charAt(j)=='1'){
                    alan+=extra;
                    ans.add(extra);
                }
                extra--;
            }
            bar=sum-alan;
            double r2=(double) alan/bar;
            if(r1==r2)
                return ans;
        }
        return null;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        for(int i=1;i<=testCase;i++){
            int n=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            List<Integer> ans=solve(n,x,y);
            if(ans==null || ans.isEmpty())
                System.out.println("Case #"+i+": IMPOSSIBLE");
            else{
                System.out.println("Case #"+i+": POSSIBLE");
                System.out.println(ans.size());
                Collections.sort(ans);
                for(Integer a:ans)
                    System.out.print(a+" ");
                System.out.println();
            }
        }
    }
}