package com.algo.tree;

/**
 *
 * @author dai
 */
public class HfmNode implements Comparable<HfmNode>{

	/**
	 * 节点里面的字符
	 */
	String chars;
	/**
	 * 表示是频率
	 */
	int weight;
	/**
	 * 左节点
	 */
	HfmNode left;
	/**
	 * 右节点
	 */
	HfmNode right;
	/**
	 * 用来找上层的
	 */
	HfmNode parent;
	
	@Override
	public int compareTo(HfmNode o) {
		// 优先队列,小的优先级调高
		return this.weight - o.weight;
	}
	
}
