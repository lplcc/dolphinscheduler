/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.dolphinscheduler.e2e.pages.security;

import org.apache.dolphinscheduler.e2e.core.WebDriverWaitFactory;
import org.apache.dolphinscheduler.e2e.pages.common.NavBarPage;
import org.apache.dolphinscheduler.e2e.pages.common.NavBarPage.NavBarItem;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;

import java.time.Duration;

@Getter
public class SecurityPage extends NavBarPage implements NavBarItem {

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(1) > .n-menu-item-content")
    private WebElement menuTenantManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(2) > .n-menu-item-content")
    private WebElement menUserManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(5) > .n-menu-item-content")
    private WebElement menWorkerGroupManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(6) > .n-menu-item-content")
    private WebElement menuQueueManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(7) > .n-menu-item-content")
    private WebElement menuEnvironmentManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(8) > .n-menu-item-content")
    private WebElement menuClusterManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(9) > .n-menu-item-content")
    private WebElement menuNamespaceManage;

    @FindBy(css = ".tab-vertical > .n-menu-item:nth-child(10) > .n-menu-item-content")
    private WebElement menuTokenManage;

    public SecurityPage(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends SecurityPage.Tab> T goToTab(Class<T> tab) {

        if (tab == TenantPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuTenantManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuTenantManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/tenant-manage"));
            return tab.cast(new TenantPage(driver));
        }

        if (tab == UserPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menUserManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menUserManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/user-manage"));
            return tab.cast(new UserPage(driver));
        }

        if (tab == WorkerGroupPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menWorkerGroupManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menWorkerGroupManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/worker-group-manage"));
            return tab.cast(new WorkerGroupPage(driver));
        }

        if (tab == QueuePage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuQueueManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuQueueManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/yarn-queue-manage"));
            return tab.cast(new QueuePage(driver));
        }

        if (tab == EnvironmentPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuEnvironmentManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuEnvironmentManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/environment-manage"));
            return tab.cast(new EnvironmentPage(driver));
        }

        if (tab == ClusterPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuClusterManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuClusterManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/cluster-manage"));
            return tab.cast(new ClusterPage(driver));
        }

        if (tab == TokenPage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuTokenManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuTokenManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/token-manage"));
            return tab.cast(new TokenPage(driver));
        }

        if (tab == NamespacePage.class) {
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(menuNamespaceManage));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuNamespaceManage());
            WebDriverWaitFactory.createWebDriverWait(driver).until(ExpectedConditions.urlContains("/security/k8s-namespace-manage"));
            return tab.cast(new NamespacePage(driver));
        }

        throw new UnsupportedOperationException("Unknown tab: " + tab.getName());
    }

    public interface Tab {
    }
}
