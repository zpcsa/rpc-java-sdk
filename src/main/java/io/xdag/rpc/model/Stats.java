package io.xdag.rpc.model;

import java.io.Serializable;

/**
 * 账户信息model
 * @author jerry
 *
 */
public class Stats  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * hash率
	 */
	private String hashrate;

	/**
	 * 总hash率
	 */
	private String totalhashrate;
	
	private String hosts;
	
	private String totalhosts;
	
	private String blocks;
	
	private String totalblocks;
	
	private String mainblocks;
	
	private String totalmainblocks;
	
	private String orphanblocks;
	
	private String waitsyncblocks;
	
	/**
	 * 区块难度
	 */
	private String difficulty;
	
	/**
	 * 最大难度
	 */
	private String maxdifficulty;
	
	private String supply;
	
	private String totalsupply;

	
	public String getHashrate() {
		return hashrate;
	}


	public void setHashrate(String hashrate) {
		this.hashrate = hashrate;
	}


	public String getTotalhashrate() {
		return totalhashrate;
	}


	public void setTotalhashrate(String totalhashrate) {
		this.totalhashrate = totalhashrate;
	}


	public String getHosts() {
		return hosts;
	}


	public void setHosts(String hosts) {
		this.hosts = hosts;
	}


	public String getTotalhosts() {
		return totalhosts;
	}


	public void setTotalhosts(String totalhosts) {
		this.totalhosts = totalhosts;
	}


	public String getBlocks() {
		return blocks;
	}


	public void setBlocks(String blocks) {
		this.blocks = blocks;
	}


	public String getTotalblocks() {
		return totalblocks;
	}


	public void setTotalblocks(String totalblocks) {
		this.totalblocks = totalblocks;
	}


	public String getMainblocks() {
		return mainblocks;
	}


	public void setMainblocks(String mainblocks) {
		this.mainblocks = mainblocks;
	}


	public String getTotalmainblocks() {
		return totalmainblocks;
	}


	public void setTotalmainblocks(String totalmainblocks) {
		this.totalmainblocks = totalmainblocks;
	}


	public String getOrphanblocks() {
		return orphanblocks;
	}


	public void setOrphanblocks(String orphanblocks) {
		this.orphanblocks = orphanblocks;
	}


	public String getWaitsyncblocks() {
		return waitsyncblocks;
	}


	public void setWaitsyncblocks(String waitsyncblocks) {
		this.waitsyncblocks = waitsyncblocks;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getMaxdifficulty() {
		return maxdifficulty;
	}


	public void setMaxdifficulty(String maxdifficulty) {
		this.maxdifficulty = maxdifficulty;
	}


	public String getSupply() {
		return supply;
	}


	public void setSupply(String supply) {
		this.supply = supply;
	}


	public String getTotalsupply() {
		return totalsupply;
	}


	public void setTotalsupply(String totalsupply) {
		this.totalsupply = totalsupply;
	}


	@Override
	public String toString() {
		return "Stats [hashrate=" + hashrate + ", totalhashrate=" + totalhashrate + ", hosts=" + hosts + ", totalhosts="
				+ totalhosts + ", blocks=" + blocks + ", totalblocks=" + totalblocks + ", mainblocks=" + mainblocks
				+ ", totalmainblocks=" + totalmainblocks + ", orphanblocks=" + orphanblocks + ", waitsyncblocks="
				+ waitsyncblocks + ", difficulty=" + difficulty + ", maxdifficulty=" + maxdifficulty + ", supply="
				+ supply + ", totalsupply=" + totalsupply + "]";
	}
	
}
