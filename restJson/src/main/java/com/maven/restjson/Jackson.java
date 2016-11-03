/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.restjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jorge
 */
public class Jackson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        String resultadoServer ="{\"code\":200,\"message\":\"\",\"data\":[{\"account\":{\"number\":\"50241109321\",\"reseller_id\":0,\"pricelist_id\":1,\"status\":false,\"sweep_id\":\"2\",\"creation\":\"2016-10-25T10:24:35-0500\",\"credit_limit\":0,\"posttoexternal\":false,\"balance\":0,\"password\":\"XCXL3DB\",\"first_name\":\"50241109321\",\"last_name\":\"\",\"company_name\":\"\",\"address1\":\"\",\"address2\":\"\",\"postal_code\":\"\",\"province\":\"\",\"city\":\"\",\"country_id\":203,\"telephone1\":\"\",\"telephone2\":\"\",\"email\":\"\",\"language_id\":2,\"currency_id\":139,\"maxchannels\":1,\"dialed_modify\":\"\",\"type\":false,\"timezone_id\":14,\"inuse\":0,\"deleted\":false,\"notify_credit_limit\":0,\"notify_flag\":false,\"notify_email\":\"0\",\"commission_rate\":0,\"invoice_day\":1,\"pin\":\"\",\"first_used\":\"2016-10-25T10:24:35-0500\",\"expiry\":\"2025-12-12T23:59:59-0600\",\"validfordays\":3652,\"local_call_cost\":0,\"pass_link_status\":false,\"local_call\":true,\"charge_per_min\":\"0\",\"is_recording\":true,\"allow_ip_management\":true,\"id\":29}},{\"animap\":{\"number\":\"50241109321\",\"accountid\":29,\"status\":false,\"context\":\"default\",\"creation_date\":\"2016-10-25T10:24:35-0500\",\"last_modified_date\":\"2016-10-25T10:24:35-0500\",\"id\":24}}]}";
     ObjectMapper JSON_MAPPER = new ObjectMapper();
     AcountUser acount = JSON_MAPPER.readValue(new URL("http://192.168.5.44/app_dev.php/cus/getaccount/50241109321.json"), AcountUser.class);
     System.out.println(acount.getFirt_Name());
    }
    
    
}
