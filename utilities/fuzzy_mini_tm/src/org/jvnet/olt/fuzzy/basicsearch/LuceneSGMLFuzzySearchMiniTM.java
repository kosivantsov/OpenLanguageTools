
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.fuzzy.basicsearch;

import org.jvnet.olt.index.AbstractFuzzySearchMiniTM;
import org.jvnet.olt.index.MatchQualityCalculator;
import org.jvnet.olt.minitm.*;
import org.jvnet.olt.lucene.LuceneMiniTM;

/**
 *  This class is the MiniTM class that extracts the markup from SGML
 *  strings and treats them separately from the text of the string. All
 *  the fuzzy matching is done on the plaintext string. The markup is then
 *  is compared, and matches are penalized based on the level of markup
 *  differences, between thema nd the query string. This prevents matches
 *  being returned for segments that have lots of similar formatting and
 *  only a little actual translatable text in common.
 */
public class LuceneSGMLFuzzySearchMiniTM extends LuceneMiniTM implements MiniTM
{
  public static final int ATTRIBUTED_TAG_PENALTY = 5;
  public static final int PLAIN_TAG_PENALTY = 2;

  public LuceneSGMLFuzzySearchMiniTM(String tmFile,
				    boolean boolCreateIfMissing,
				    String miniTmName,
				    String sourceLang,
				    String targetLang)
    throws MiniTMException
  {
    super(tmFile, boolCreateIfMissing, miniTmName, sourceLang, targetLang );
  }

  protected FormatRemovingStrategy selectFormatRemover()
  {
    return new SGMLFormatRemovingStrategy();
  }

  protected TMMatch createMatch(String sourceString,
				TMUnit unit)
    throws MiniTMException
  {
    //  Adjust match quality figures based on the formatting.
    //  Build up a list of differences
    String refString = unit.getSource();   

    FormatRemovingStrategy rf = this.selectFormatRemover();
    
    float matchQuality = MatchQualityCalculator.calculateMatchQuality(sourceString, refString, rf);
    int formatDiff = MatchQualityCalculator.calculateFormatPenalty(sourceString, refString, rf);

    //  Create match object
    TMMatch match = new TMMatch(unit, (int) matchQuality, formatDiff);

    return match;
  }
}
