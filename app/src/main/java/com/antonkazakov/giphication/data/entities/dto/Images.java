package com.antonkazakov.giphication.data.entities.dto;

import com.google.gson.annotations.SerializedName;

public class Images{

	@SerializedName("original")
	private Original original;

	@SerializedName("fixed_height_small")
	private FixedHeightSmall fixedHeightSmall;

	@SerializedName("fixed_width")
	private FixedWidth fixedWidth;

	@SerializedName("downsized_still")
	private DownsizedStill downsizedStill;

	@SerializedName("downsized_large")
	private DownsizedLarge downsizedLarge;

	@SerializedName("fixed_height_downsampled")
	private FixedHeightDownsampled fixedHeightDownsampled;

	@SerializedName("fixed_height")
	private FixedHeight fixedHeight;

	@SerializedName("fixed_width_downsampled")
	private FixedWidthDownsampled fixedWidthDownsampled;

	@SerializedName("fixed_height_small_still")
	private FixedHeightSmallStill fixedHeightSmallStill;

	@SerializedName("fixed_width_small")
	private FixedWidthSmall fixedWidthSmall;

	@SerializedName("fixed_height_still")
	private FixedHeightStill fixedHeightStill;

	@SerializedName("fixed_width_small_still")
	private FixedWidthSmallStill fixedWidthSmallStill;

	@SerializedName("fixed_width_still")
	private FixedWidthStill fixedWidthStill;

	@SerializedName("downsized")
	private Downsized downsized;

	@SerializedName("original_still")
	private OriginalStill originalStill;

	public void setOriginal(Original original){
		this.original = original;
	}

	public Original getOriginal(){
		return original;
	}

	public void setFixedHeightSmall(FixedHeightSmall fixedHeightSmall){
		this.fixedHeightSmall = fixedHeightSmall;
	}

	public FixedHeightSmall getFixedHeightSmall(){
		return fixedHeightSmall;
	}

	public void setFixedWidth(FixedWidth fixedWidth){
		this.fixedWidth = fixedWidth;
	}

	public FixedWidth getFixedWidth(){
		return fixedWidth;
	}

	public void setDownsizedStill(DownsizedStill downsizedStill){
		this.downsizedStill = downsizedStill;
	}

	public DownsizedStill getDownsizedStill(){
		return downsizedStill;
	}

	public void setDownsizedLarge(DownsizedLarge downsizedLarge){
		this.downsizedLarge = downsizedLarge;
	}

	public DownsizedLarge getDownsizedLarge(){
		return downsizedLarge;
	}

	public void setFixedHeightDownsampled(FixedHeightDownsampled fixedHeightDownsampled){
		this.fixedHeightDownsampled = fixedHeightDownsampled;
	}

	public FixedHeightDownsampled getFixedHeightDownsampled(){
		return fixedHeightDownsampled;
	}

	public void setFixedHeight(FixedHeight fixedHeight){
		this.fixedHeight = fixedHeight;
	}

	public FixedHeight getFixedHeight(){
		return fixedHeight;
	}

	public void setFixedWidthDownsampled(FixedWidthDownsampled fixedWidthDownsampled){
		this.fixedWidthDownsampled = fixedWidthDownsampled;
	}

	public FixedWidthDownsampled getFixedWidthDownsampled(){
		return fixedWidthDownsampled;
	}

	public void setFixedHeightSmallStill(FixedHeightSmallStill fixedHeightSmallStill){
		this.fixedHeightSmallStill = fixedHeightSmallStill;
	}

	public FixedHeightSmallStill getFixedHeightSmallStill(){
		return fixedHeightSmallStill;
	}

	public void setFixedWidthSmall(FixedWidthSmall fixedWidthSmall){
		this.fixedWidthSmall = fixedWidthSmall;
	}

	public FixedWidthSmall getFixedWidthSmall(){
		return fixedWidthSmall;
	}

	public void setFixedHeightStill(FixedHeightStill fixedHeightStill){
		this.fixedHeightStill = fixedHeightStill;
	}

	public FixedHeightStill getFixedHeightStill(){
		return fixedHeightStill;
	}

	public void setFixedWidthSmallStill(FixedWidthSmallStill fixedWidthSmallStill){
		this.fixedWidthSmallStill = fixedWidthSmallStill;
	}

	public FixedWidthSmallStill getFixedWidthSmallStill(){
		return fixedWidthSmallStill;
	}

	public void setFixedWidthStill(FixedWidthStill fixedWidthStill){
		this.fixedWidthStill = fixedWidthStill;
	}

	public FixedWidthStill getFixedWidthStill(){
		return fixedWidthStill;
	}

	public void setDownsized(Downsized downsized){
		this.downsized = downsized;
	}

	public Downsized getDownsized(){
		return downsized;
	}

	public void setOriginalStill(OriginalStill originalStill){
		this.originalStill = originalStill;
	}

	public OriginalStill getOriginalStill(){
		return originalStill;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"original = '" + original + '\'' + 
			",fixed_height_small = '" + fixedHeightSmall + '\'' + 
			",fixed_width = '" + fixedWidth + '\'' + 
			",downsized_still = '" + downsizedStill + '\'' + 
			",downsized_large = '" + downsizedLarge + '\'' + 
			",fixed_height_downsampled = '" + fixedHeightDownsampled + '\'' + 
			",fixed_height = '" + fixedHeight + '\'' + 
			",fixed_width_downsampled = '" + fixedWidthDownsampled + '\'' + 
			",fixed_height_small_still = '" + fixedHeightSmallStill + '\'' + 
			",fixed_width_small = '" + fixedWidthSmall + '\'' + 
			",fixed_height_still = '" + fixedHeightStill + '\'' + 
			",fixed_width_small_still = '" + fixedWidthSmallStill + '\'' + 
			",fixed_width_still = '" + fixedWidthStill + '\'' + 
			",downsized = '" + downsized + '\'' + 
			",original_still = '" + originalStill + '\'' + 
			"}";
		}
}