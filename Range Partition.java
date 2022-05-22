import java.util.*;

class Solution{
    static List<Integer> solve(int n,int x,int y){
        List<Integer> ans=new ArrayList<>();
        long alan=0,bar=0;
        double r1=(double) x/y;
        long sum=0;
        for(int i=1;i<=n;i++)
            sum+=i;
        long i=1;
        while(alan+bar<sum){
            alan=i*x;
            bar=i*y;
            i++;
        }
        if(alan+bar==sum){
            for(int j=n;j>=1 && alan>0;j--){
                if(j<=alan){
                    ans.add(j);
                    alan-=j;
                }
            }
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