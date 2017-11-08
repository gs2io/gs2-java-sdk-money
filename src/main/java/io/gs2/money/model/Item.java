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

package io.gs2.money.model;

import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Item implements Serializable {

	/** 商品ID */
	private String itemId;

	/** 付与する仮想通貨の数 */
	private Integer count;

	/** 作成日時(エポック秒) */
	private Integer createAt;

	/** 仮想通貨ID */
	private String moneyId;

	/** 商品名 */
	private String name;

	/** 最終更新日時(エポック秒) */
	private Integer updateAt;


	/**
	 * 商品IDを取得
	 *
	 * @return 商品ID
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * 商品IDを設定
	 *
	 * @param itemId 商品ID
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * 付与する仮想通貨の数を取得
	 *
	 * @return 付与する仮想通貨の数
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 付与する仮想通貨の数を設定
	 *
	 * @param count 付与する仮想通貨の数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 作成日時(エポック秒)を取得
	 *
	 * @return 作成日時(エポック秒)
	 */
	public Integer getCreateAt() {
		return createAt;
	}

	/**
	 * 作成日時(エポック秒)を設定
	 *
	 * @param createAt 作成日時(エポック秒)
	 */
	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

	/**
	 * 仮想通貨IDを取得
	 *
	 * @return 仮想通貨ID
	 */
	public String getMoneyId() {
		return moneyId;
	}

	/**
	 * 仮想通貨IDを設定
	 *
	 * @param moneyId 仮想通貨ID
	 */
	public void setMoneyId(String moneyId) {
		this.moneyId = moneyId;
	}

	/**
	 * 商品名を取得
	 *
	 * @return 商品名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商品名を設定
	 *
	 * @param name 商品名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 最終更新日時(エポック秒)を取得
	 *
	 * @return 最終更新日時(エポック秒)
	 */
	public Integer getUpdateAt() {
		return updateAt;
	}

	/**
	 * 最終更新日時(エポック秒)を設定
	 *
	 * @param updateAt 最終更新日時(エポック秒)
	 */
	public void setUpdateAt(Integer updateAt) {
		this.updateAt = updateAt;
	}

}