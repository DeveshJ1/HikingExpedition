
import java.util.ArrayList;
import java.util.List;

public class BSTMountain {
	private static class TreeNode
	{
		RestStop data;
		TreeNode left;
		TreeNode right;
		public TreeNode(RestStop data) 
		{
			this.data=data;
		}
	}
	private TreeNode root;
	public void insert(RestStop restStop)
	{
		root=insert(root,restStop);
	}
	private TreeNode insert(TreeNode node,RestStop restStop) 
	{
		if(node==null) 
		{
			return new TreeNode(restStop);
		}
		int comp= restStop.getLabel().compareTo(node.data.getLabel());
		if(comp<0) 
		{
			node.left=insert(node.left,restStop);
		}
		else if(comp>0) 
		{
			node.right=insert(node.right,restStop);
		}
		return node; 
	}


    
	public List<List<String>> getSafePaths()
	{
		List<List<String>> paths= new ArrayList<>();
		List<String> currentPath= new ArrayList<>();
		hikerTraverse(root,currentPath,paths,new Hiker()); 
		return paths;
	}
	public int getLevel(String label) {
        return getLevel(root, label, 0);
    }

    private int getLevel(TreeNode node, String label, int currentLevel) {
        if (node == null) {
            return -1; // Return -1 for non-existent nodes
        }

        int cmp = label.compareTo(node.data.getLabel());
        if (cmp < 0) {
            // If the label is smaller, then the node is in the left subtree
            return getLevel(node.left, label, currentLevel + 1);
        } else if (cmp > 0) {
            // If the label is greater, then the node is in the right subtree
            return getLevel(node.right, label, currentLevel + 1);
        } else {
            // If the label is equal, the node is found, and its level is the current level
            return currentLevel;
        }
    }
    public int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            int lh = maxDepth(node.left);
            int rh = maxDepth(node.right);
  //since height of root or depth of root is =  0 according to definition learning 
   //in class
            if(node==root) 
            {
            	if (lh > rh)
	                return (lh);
	             else
	                return (rh);
            }
            if (lh > rh)
                return (lh + 1);
             else
                return (rh + 1);
        }
    }
	 private void hikerTraverse(TreeNode node, List<String> currentPath, List<List<String>> paths, Hiker hiker) {
	        if (node == null) 
	        {
	            return;
	        }

	        currentPath.add(node.data.getLabel());
	        hiker.consumeSupplies(node.data);
	       System.out.println(hiker.getSupplies() + " " + node.data.getLabel());
	        // Check if the hiker can pass the rest stop with obstacles
	       
	        if( getLevel(node.data.getLabel())==maxDepth(root))
	        {
	        	paths.add(new ArrayList<>(currentPath));
	        }
	        else  if (!hiker.canPassObstacles(node.data))
	        {
	            // If the hiker doesn't have required supplies, skip this path
	            currentPath.remove(currentPath.size() - 1);
	            hiker.undoConsumption(node.data);
	            return;
	        }
	        else 
			{
				hiker.useSupplies(node.data);
	        	hikerTraverse(node.left,currentPath,paths,hiker);
				hikerTraverse(node.right,currentPath,paths,hiker);

			}
        	hiker.undoUse(node.data);
	        currentPath.remove(currentPath.size()-1);
	        hiker.undoConsumption(node.data);
	}
}
