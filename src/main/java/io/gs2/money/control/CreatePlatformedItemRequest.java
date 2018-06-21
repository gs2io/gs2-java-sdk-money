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

import org.json.JSONObject;
import java.util.List;
import io.gs2.money.Gs2Money;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class CreatePlatformedItemRequest extends Gs2BasicRequest<CreatePlatformedItemRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "CreatePlatformedItem";
	}

	/** 仮想通貨の名前 */
	private String moneyName;

	/** 商品の名前 */
	private String itemName;

	/** 販売プラットフォーム */
	private String platform;

	/** アプリ内課金ID */
	private String name;

	/** 販売価格 */
	private Double price;


	/**
	 * 仮想通貨の名前を取得
	 *
	 * @return 仮想通貨の名前
	 */
	public String getMoneyName() {
		return moneyName;
	}

	/**
	 * 仮想通貨の名前を設定
	 *
	 * @param moneyName 仮想通貨の名前
	 */
	public void setMoneyName(String moneyName) {
		this.moneyName = moneyName;
	}

	/**
	 * 仮想通貨の名前を設定
	 *
	 * @param moneyName 仮想通貨の名前
	 * @return this
	 */
	public CreatePlatformedItemRequest withMoneyName(String moneyName) {
		setMoneyName(moneyName);
		return this;
	}

	/**
	 * 商品の名前を取得
	 *
	 * @return 商品の名前
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品の名前を設定
	 *
	 * @param itemName 商品の名前
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 商品の名前を設定
	 *
	 * @param itemName 商品の名前
	 * @return this
	 */
	public CreatePlatformedItemRequest withItemName(String itemName) {
		setItemName(itemName);
		return this;
	}

	/**
	 * 販売プラットフォームを取得
	 *
	 * @return 販売プラットフォーム
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * 販売プラットフォームを設定
	 *
	 * @param platform 販売プラットフォーム
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * 販売プラットフォームを設定
	 *
	 * @param platform 販売プラットフォーム
	 * @return this
	 */
	public CreatePlatformedItemRequest withPlatform(String platform) {
		setPlatform(platform);
		return this;
	}

	/**
	 * アプリ内課金IDを取得
	 *
	 * @return アプリ内課金ID
	 */
	public String getName() {
		return name;
	}

	/**
	 * アプリ内課金IDを設定
	 *
	 * @param name アプリ内課金ID
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * アプリ内課金IDを設定
	 *
	 * @param name アプリ内課金ID
	 * @return this
	 */
	public CreatePlatformedItemRequest withName(String name) {
		setName(name);
		return this;
	}

	/**
	 * 販売価格を取得
	 *
	 * @return 販売価格
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 販売価格を設定
	 *
	 * @param price 販売価格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 販売価格を設定
	 *
	 * @param price 販売価格
	 * @return this
	 */
	public CreatePlatformedItemRequest withPrice(Double price) {
		setPrice(price);
		return this;
	}

}