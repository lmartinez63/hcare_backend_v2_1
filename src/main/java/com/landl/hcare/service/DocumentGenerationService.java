package com.landl.hcare.service;

import java.util.Map;

public interface DocumentGenerationService {

    public String generateDocument(String templateCode, String outputFormat, Map dataSource) throws Exception;


}
