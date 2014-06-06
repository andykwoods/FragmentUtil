package com.awoods.fragmentutil;

import android.annotation.SuppressLint;
@SuppressLint("NewApi")

public class FragmentUtil {

	
	public enum FragmentSlideAnimation {fromtop, frombottom, fromright, fromleft};
	
	/**
	 * I get the slide in and out animations based on the FragmentSlideAnimation
	 * @param animation
	 * @return int array of size 2 of animations resource id's
	 */
	public static int[] getSlideAnimations(FragmentSlideAnimation animation){
		int [] animations = new int [2];
		if (animation.equals(FragmentSlideAnimation.fromtop)){
			animations[0] = R.anim.slide_in_from_top;
			animations[1] = R.anim.slide_out_to_top;
		}
		else if (animation.equals(FragmentSlideAnimation.frombottom)){
			animations[0] = R.anim.slide_in_from_bottom;
			animations[1] = R.anim.slide_out_to_bottom;
		}
		else if (animation.equals(FragmentSlideAnimation.fromleft)){
			animations[0] = R.anim.slide_in_from_left;
			animations[1] = R.anim.slide_out_to_left;
		}
		else if (animation.equals(FragmentSlideAnimation.fromright)){
			animations[0] = R.anim.slide_in_from_right;
			animations[1] = R.anim.slide_out_to_right;
    	}
		return animations;
	}
	
	
	
	//================================================================================
    // android.app.Fragment handling
    //================================================================================
	
	/**
	 * I hide a fragment
	 * @param frag
	 * @param fragmentManager
	 */
	public static void hideFragment(android.app.Fragment frag, android.app.FragmentManager fragmentManager){
		android.app.FragmentTransaction ft = fragmentManager.beginTransaction();
		hideFragment(frag, ft);
    }
	
	/**
	 * I hide a fragment
	 * @param frag
	 * @param fragmentTransaction
	 */
	public static void hideFragment(android.app.Fragment frag, android.app.FragmentTransaction fragmentTransaction){
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB){
			if (frag != null){
				fragmentTransaction.hide(frag);
				fragmentTransaction.commit();
			}
		}
    }
	
	/**
	 * I show a fragment on content
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 */
	public static void showFragmentOnContent(android.app.FragmentManager fragmentManager, android.app.Fragment frag, String backStackArg){
		showFragmentOnContent(fragmentManager, frag, backStackArg, null);
    }
	
	/**
	 * I show a fragment on content
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 * @param animation
	 */
	public static void showFragmentOnContent(android.app.FragmentManager fragmentManager, android.app.Fragment frag, String backStackArg, FragmentSlideAnimation animation){
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB){
			android.app.FragmentTransaction ft = fragmentManager.beginTransaction();
			showFragmentOnContent(ft, frag, backStackArg, animation);
		}
    }
	
	
	/**
	 * I show a fragment on content
	 * @param fragmentTransaction
	 * @param frag
	 * @param backStackArg
	 * @param animation
	 */
	public static void showFragmentOnContent(android.app.FragmentTransaction fragmentTransaction, android.app.Fragment frag, String backStackArg,  FragmentSlideAnimation animation){
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB){
			fragmentTransaction.add(android.R.id.content, frag);
	    	if (backStackArg != null)fragmentTransaction.addToBackStack(backStackArg);
	    	if (animation != null){
	    		int [] animations = getSlideAnimations(animation);
	    		fragmentTransaction.setCustomAnimations(animations[0], animations[1], animations[0], animations[1]);
	    	}
			fragmentTransaction.show(frag);
			fragmentTransaction.commit();
		}
    }
	
	/**
	 * I show a fragment on content with a tag
	 * @param fragmentManager
	 * @param frag
	 * @param tag
	 */
	public static void showFragmentOnContentWithTag(android.app.FragmentManager fragmentManager, android.app.Fragment frag, String tag){
    	showFragmentOnContentWithTag(fragmentManager, frag, null, tag);
    }
	/**
	 * I show a fragment on content with a tag
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 */
	public static void showFragmentOnContentWithTag(android.app.FragmentManager fragmentManager, android.app.Fragment frag, String backStackArg, String tag){
		android.app.FragmentTransaction ft = fragmentManager.beginTransaction();
    	showFragmentOnContentWithTag(ft, frag, backStackArg, tag);
    }
    /**
     * I show a fragment on content with a tag
     * @param fragmentTransaction
     * @param frag
     * @param tag
     */
	public static void showFragmentOnContentWithTag(android.app.FragmentTransaction fragmentTransaction, android.app.Fragment frag, String tag){
		showFragmentOnContentWithTag(fragmentTransaction, frag, null, tag);
    }
	/**
	 * I show a fragment on content with a tag
	 * @param fragmentTransaction
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 */
	public static void showFragmentOnContentWithTag(android.app.FragmentTransaction fragmentTransaction, android.app.Fragment frag, String backStackArg, String tag){
		showFragmentOnContentWithTag(fragmentTransaction, frag, backStackArg, tag, null);
    }
	
	/**
	 * I show a fragment on content with a tag
	 * @param fragmentTransaction
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 * @param animation
	 */
	public static void showFragmentOnContentWithTag(android.app.FragmentTransaction fragmentTransaction, android.app.Fragment frag, String backStackArg, String tag, FragmentSlideAnimation animation){
		fragmentTransaction.add(android.R.id.content, frag, tag);
    	if (backStackArg != null)fragmentTransaction.addToBackStack(backStackArg);
    	if (animation != null){
    		int [] animations = getSlideAnimations(animation);
    		fragmentTransaction.setCustomAnimations(animations[0], animations[1], animations[0], animations[1]);
    	}
    	fragmentTransaction.show(frag);
		fragmentTransaction.commit();
	}
	
	
	
	//================================================================================
    // android.support.v4.app.Fragment handling
    //================================================================================
	
	/**
	 * I hide a v4 fragment
	 * @param frag
	 * @param fragmentManager
	 */
	public static void hideV4Fragment(android.support.v4.app.Fragment frag, android.support.v4.app.FragmentManager fragmentManager){
		android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
		hideV4Fragment(frag, ft);
    }
	
	/**
	 * I hide a v4 fragment
	 * @param frag
	 * @param ft
	 */
	public static void hideV4Fragment(android.support.v4.app.Fragment frag, android.support.v4.app.FragmentTransaction fragmentTransaction){
    	if (frag != null){
    		fragmentTransaction.hide(frag);
    		fragmentTransaction.commit();
    	}
    }
	
    /**
     * I show a v4 fragment on the content
     * @param fragmentManager
     * @param frag
     */
	public static void showV4FragmentOnContent(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag){
    	showV4FragmentOnContent(fragmentManager, frag, null);
    }
	
	/**
	 * I show a v4 fragment on the content
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 */
	public static void showV4FragmentOnContent(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag, String backStackArg){
		showV4FragmentOnContent(fragmentManager, frag, backStackArg, null);
    }
	
	/**
	 * I show a v4 fragment on content
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 * @param animation
	 */
	public static void showV4FragmentOnContent(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag, String backStackArg, FragmentSlideAnimation animation){
		android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
		showV4FragmentOnContent(ft, frag, backStackArg, animation);
    }
	
	
    /**
     * I show a v4 fragment on the content
     * @param fragmentTransaction
     * @param frag
     * @param backStackArg
     * @param animation
     */
	public static void showV4FragmentOnContent(android.support.v4.app.FragmentTransaction fragmentTransaction, android.support.v4.app.Fragment frag, String backStackArg, FragmentSlideAnimation animation){
    	fragmentTransaction.add(android.R.id.content, frag);
    	if (backStackArg != null)fragmentTransaction.addToBackStack(backStackArg);
    	if (animation != null){
    		int [] animations = getSlideAnimations(animation);
    		fragmentTransaction.setCustomAnimations(animations[0], animations[1], animations[0], animations[1]);
    	}
		fragmentTransaction.show(frag);
		fragmentTransaction.commit();
    }
    
	
	
	/**
	 * I show a v4 fragment on the content with a provided tag
	 * @param fragmentManager
	 * @param frag
	 * @param tag
	 */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag, String tag){
    	showV4FragmentOnContentWithTag(fragmentManager, frag, null, tag);
    }
	
	/**
	 * I show a v4 fragment on the content with a provided tag and back stack argument
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag, String backStackArg, String tag){
		showV4FragmentOnContentWithTag(fragmentManager, frag, backStackArg, tag, null);
    }
	
	/**
	 * I show a v4 fragment on the content with a provided tag, back stack argument and animation
	 * @param fragmentManager
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 * @param animation
	 */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment frag, String backStackArg, String tag, FragmentSlideAnimation animation){
		android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
    	showV4FragmentOnContentWithTag(ft, frag, backStackArg, tag, animation);
    }
	
    /**
     * I show a v4 fragment on the content with a provided tag
     * @param fragmentTransaction
     * @param frag
     * @param tag
     */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentTransaction fragmentTransaction, android.support.v4.app.Fragment frag, String tag){
		showV4FragmentOnContentWithTag(fragmentTransaction, frag, null, tag);
    }
	/**
	 * I show a v4 fragment on the content with a provided tag and back stack argument
	 * @param fragmentTransaction
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentTransaction fragmentTransaction, android.support.v4.app.Fragment frag, String backStackArg, String tag){
		showV4FragmentOnContentWithTag(fragmentTransaction, frag, backStackArg, tag, null);
    }
	
	/**
	 * I show a v4 fragment on the content with a provided tag, back stack argument and animation
	 * @param fragmentTransaction
	 * @param frag
	 * @param backStackArg
	 * @param tag
	 * @param animation
	 */
	public static void showV4FragmentOnContentWithTag(android.support.v4.app.FragmentTransaction fragmentTransaction, android.support.v4.app.Fragment frag, String backStackArg, String tag, FragmentSlideAnimation animation){
    	fragmentTransaction.add(android.R.id.content, frag, tag);
    	if (backStackArg != null)fragmentTransaction.addToBackStack(backStackArg);
    	if (animation != null){
    		int [] animations = getSlideAnimations(animation);
    		fragmentTransaction.setCustomAnimations(animations[0], animations[1], animations[0], animations[1]);
    	}
    	fragmentTransaction.show(frag);
		fragmentTransaction.commit();
    }
	
	
	
}
