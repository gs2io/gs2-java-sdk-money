/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.money.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.gs2.money.model.Money;


/**
 * @author Game Server Services, Inc.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateMoneyResult {

	/** 仮想通貨 */
	Money item;


	/**
	 * 仮想通貨を取得
	 *
	 * @return 仮想通貨
	 */
	public Money getItem() {
		return item;
	}

	/**
	 * 仮想通貨を設定
	 *
	 * @param item 仮想通貨
	 */
	public void setItem(Money item) {
		this.item = item;
	}

}