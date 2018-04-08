/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.healthcheck.core;

import com.alipay.sofa.healthcheck.log.SofaBootHealthCheckLoggerFactory;
import com.alipay.sofa.healthcheck.startup.StartUpHealthCheckStatus;
import org.slf4j.Logger;

/**
 *
 * @author liangen
 * @version $Id: SpringContextCheckProcessor.java, v 0.1 2018年02月01日 下午6:16 liangen Exp $
 */
public class SpringContextCheckProcessor {

    private static Logger logger = SofaBootHealthCheckLoggerFactory.getLogger(SpringContextCheckProcessor.class
                                     .getCanonicalName());

    public boolean springContextCheck() {
        logger.info("Begin springContext health check.");

        boolean isHealth = HealthCheckManager.springContextCheck();

        if (isHealth) {
            logger.info("springContext check result: success.");
        } else {
            logger.error("springContext check result: fail.");
        }

        StartUpHealthCheckStatus.setSpringContextStatus(isHealth);

        return isHealth;
    }

}