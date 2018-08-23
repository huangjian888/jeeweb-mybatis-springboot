package cn.jeeweb.core.common.entity.tree;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BootstrapTreeNode implements Serializable {
	private String text;
	private String href;
	private String[] tags;
	private List<BootstrapTreeNode> nodes;

	public BootstrapTreeNode() {
	}

	public BootstrapTreeNode(TreeNode<?> treeNode) {
		this.text = treeNode.getName();
		this.href = treeNode.getId() + "";
		this.tags=treeNode.makeTags();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public List<BootstrapTreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<BootstrapTreeNode> nodes) {
		this.nodes = nodes;
	}

}
