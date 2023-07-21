package com.example.L07restfullservicedemo;

import org.gfg.analyzer.KeywordAnalyzerImpl;
import org.gfg.analyzer.KeywordAnalyzerInterface;
import org.gfg.analyzer.UniqueKeywordAnalyzerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
     //Its a ambigious situation so we are saying that to use primary bean
    @Primary
    @Bean("uniqueKeywordAnalyzerImpl")
    public KeywordAnalyzerInterface getKeywordAnalyzerInterface(){
        return new UniqueKeywordAnalyzerImpl();
    }

    @Bean("keywordAnalyzerImpl")
    public KeywordAnalyzerInterface getBasicKeywordAnalyzerInterface(){
        return new KeywordAnalyzerImpl();
    }

}

