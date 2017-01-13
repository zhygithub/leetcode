package leetcode;

/**
 * Created by ZhengHy on 2017-01-13.
 */
public class BuildTreeFormPreorderAndInorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "[\tval = " + val +
                    "\tleft = " + (left == null ? "NULL" : left.toString())+
                    "\tright =" + (right == null ? "NULL" : right.toString())+
                   "]\n";
        }
    }

    /**
     * 通过递归构造二叉树，效率不高，这个算法做改进，不要切割数组，传递必要的参数即可，可以增加效率
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 ){
            return null;
        }

        TreeNode node  = new TreeNode(preorder[0]);


        int headIndex = -1;
        for(headIndex = 0 ; headIndex < inorder.length ; headIndex++){
            if(inorder[headIndex] == preorder[0]){
                break;
            }
        }
        int[] leftInorder = new int[headIndex];
        int[] rightInorder = new int[inorder.length - headIndex -1];
        System.arraycopy(inorder,0,leftInorder,0,headIndex);
        System.arraycopy(inorder,headIndex + 1,rightInorder,0,inorder.length - headIndex -1);

        int[] leftPreOrder = new int[headIndex];
        int[] rightPreorder = new int[inorder.length - headIndex -1];
        System.arraycopy(preorder,1,leftPreOrder,0,headIndex);
        System.arraycopy(preorder,headIndex+1,rightPreorder,0,inorder.length - headIndex -1);
        node.left = buildTree(leftPreOrder,leftInorder);
        node.right = buildTree(rightPreorder,rightInorder);

        return node;
    }

    public static void printTree(TreeNode node){
        if(node == null){
            return ;
        }

        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
    }


    public static void main(String[] args){
        int[] a = new int[]{
                1, 2 ,4 ,5 ,3 ,6 ,7
        };
        int[] b = new int[]{
                4 ,2 ,5 ,1 ,6 ,3 ,7
        };
        BuildTreeFormPreorderAndInorder d = new BuildTreeFormPreorderAndInorder();
        printTree(d.buildTree(a,b));
    }
}
