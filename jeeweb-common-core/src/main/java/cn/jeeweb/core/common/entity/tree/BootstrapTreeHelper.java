package cn.jeeweb.core.common.entity.tree;

import cn.jeeweb.core.utils.ObjectUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树排序
 * 
 * @author auth_team
 *
 */
public class BootstrapTreeHelper<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TreeNode<ID>> treeNodes;

	public static <T extends Serializable> BootstrapTreeHelper<T> create() {
		BootstrapTreeHelper<T> treeSortUtil = new BootstrapTreeHelper<T>();
		return treeSortUtil;
	}

	/**
	 * 获得根节点
	 * 
	 * @param trees
	 */
	public List<BootstrapTreeNode> getTopNodes() {
		List<BootstrapTreeNode> list = new ArrayList<BootstrapTreeNode>();
		for (TreeNode<ID> treeable : treeNodes) {
			if (treeable.isRoot()) {
				list.add(new BootstrapTreeNode(treeable));
			}
		}
		return list;
	}

	/**
	 * 解析根节点
	 * 
	 * @param trees
	 */
	public void parseSubNode(BootstrapTreeNode node) {
		List<BootstrapTreeNode> newTreeNodes = new ArrayList<BootstrapTreeNode>();
		for (TreeNode<ID> treeable : treeNodes) {
			if (!ObjectUtils.isNullOrEmpty(treeable.getParentId()) && treeable.getParentId().equals(node.getHref())) {
				BootstrapTreeNode bootstrapTreeNode = new BootstrapTreeNode(treeable);
				newTreeNodes.add(bootstrapTreeNode);
				parseSubNode(bootstrapTreeNode);
				node.setNodes(newTreeNodes);
			}
		}
	}

	/**
	 * 运行排序
	 */
	@SuppressWarnings("unchecked")
	public List<BootstrapTreeNode> sort(List<?> treeNodes) {
		this.treeNodes = (List<TreeNode<ID>>) treeNodes;
		List<BootstrapTreeNode> rootNodes = getTopNodes();
		for (BootstrapTreeNode rootNode : rootNodes) {
			parseSubNode(rootNode);
		}
		this.treeNodes.clear();
		return rootNodes;
	}

}
