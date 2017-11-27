/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arem.tallerfinal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author rami
 */
@SpringBootApplication
@ComponentScan(basePackages = {"arem.tallerfinal"})
public class TallerFinalApi {

    public static void main(String[] args) {
        SpringApplication.run(TallerFinalApi.class, args);
    }
}
