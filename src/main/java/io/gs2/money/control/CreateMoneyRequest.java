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
public class CreateMoneyRequest extends Gs2BasicRequest<CreateMoneyRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "CreateMoney";
	}

	/** ストアプラットフォームのレシートの検証機能を利用するか */
	private Boolean useVerifyReceipt;

	/** 仮想通貨名 */
	private String name;

	/** Google のレシート検証用公開鍵 */
	private String googleKey;

	/** 支払い優先度 */
	private String priority;

	/** 通貨 */
	private String currency;

	/** 無償仮想通貨を異なるスロットで共有するか */
	private Boolean shareFree;

	/** Apple のアプリケーションバンドルID */
	private String appleKey;

	/** 説明文(1024文字以内) */
	private String description;


	/**
	 * ストアプラットフォームのレシートの検証機能を利用するかを取得
	 *
	 * @return ストアプラットフォームのレシートの検証機能を利用するか
	 */
	public Boolean getUseVerifyReceipt() {
		return useVerifyReceipt;
	}

	/**
	 * ストアプラットフォームのレシートの検証機能を利用するかを設定
	 *
	 * @param useVerifyReceipt ストアプラットフォームのレシートの検証機能を利用するか
	 */
	public void setUseVerifyReceipt(Boolean useVerifyReceipt) {
		this.useVerifyReceipt = useVerifyReceipt;
	}

	/**
	 * ストアプラットフォームのレシートの検証機能を利用するかを設定
	 *
	 * @param useVerifyReceipt ストアプラットフォームのレシートの検証機能を利用するか
	 * @return this
	 */
	public CreateMoneyRequest withUseVerifyReceipt(Boolean useVerifyReceipt) {
		setUseVerifyReceipt(useVerifyReceipt);
		return this;
	}

	/**
	 * 仮想通貨名を取得
	 *
	 * @return 仮想通貨名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 仮想通貨名を設定
	 *
	 * @param name 仮想通貨名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 仮想通貨名を設定
	 *
	 * @param name 仮想通貨名
	 * @return this
	 */
	public CreateMoneyRequest withName(String name) {
		setName(name);
		return this;
	}

	/**
	 * Google のレシート検証用公開鍵を取得
	 *
	 * @return Google のレシート検証用公開鍵
	 */
	public String getGoogleKey() {
		return googleKey;
	}

	/**
	 * Google のレシート検証用公開鍵を設定
	 *
	 * @param googleKey Google のレシート検証用公開鍵
	 */
	public void setGoogleKey(String googleKey) {
		this.googleKey = googleKey;
	}

	/**
	 * Google のレシート検証用公開鍵を設定
	 *
	 * @param googleKey Google のレシート検証用公開鍵
	 * @return this
	 */
	public CreateMoneyRequest withGoogleKey(String googleKey) {
		setGoogleKey(googleKey);
		return this;
	}

	/**
	 * 支払い優先度を取得
	 *
	 * @return 支払い優先度
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * 支払い優先度を設定
	 *
	 * @param priority 支払い優先度
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * 支払い優先度を設定
	 *
	 * @param priority 支払い優先度
	 * @return this
	 */
	public CreateMoneyRequest withPriority(String priority) {
		setPriority(priority);
		return this;
	}

	/**
	 * 通貨を取得
	 *
	 * @return 通貨
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 通貨を設定
	 *
	 * @param currency 通貨
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 通貨を設定
	 *
	 * @param currency 通貨
	 * @return this
	 */
	public CreateMoneyRequest withCurrency(String currency) {
		setCurrency(currency);
		return this;
	}

	/**
	 * 無償仮想通貨を異なるスロットで共有するかを取得
	 *
	 * @return 無償仮想通貨を異なるスロットで共有するか
	 */
	public Boolean getShareFree() {
		return shareFree;
	}

	/**
	 * 無償仮想通貨を異なるスロットで共有するかを設定
	 *
	 * @param shareFree 無償仮想通貨を異なるスロットで共有するか
	 */
	public void setShareFree(Boolean shareFree) {
		this.shareFree = shareFree;
	}

	/**
	 * 無償仮想通貨を異なるスロットで共有するかを設定
	 *
	 * @param shareFree 無償仮想通貨を異なるスロットで共有するか
	 * @return this
	 */
	public CreateMoneyRequest withShareFree(Boolean shareFree) {
		setShareFree(shareFree);
		return this;
	}

	/**
	 * Apple のアプリケーションバンドルIDを取得
	 *
	 * @return Apple のアプリケーションバンドルID
	 */
	public String getAppleKey() {
		return appleKey;
	}

	/**
	 * Apple のアプリケーションバンドルIDを設定
	 *
	 * @param appleKey Apple のアプリケーションバンドルID
	 */
	public void setAppleKey(String appleKey) {
		this.appleKey = appleKey;
	}

	/**
	 * Apple のアプリケーションバンドルIDを設定
	 *
	 * @param appleKey Apple のアプリケーションバンドルID
	 * @return this
	 */
	public CreateMoneyRequest withAppleKey(String appleKey) {
		setAppleKey(appleKey);
		return this;
	}

	/**
	 * 説明文(1024文字以内)を取得
	 *
	 * @return 説明文(1024文字以内)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 説明文(1024文字以内)を設定
	 *
	 * @param description 説明文(1024文字以内)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 説明文(1024文字以内)を設定
	 *
	 * @param description 説明文(1024文字以内)
	 * @return this
	 */
	public CreateMoneyRequest withDescription(String description) {
		setDescription(description);
		return this;
	}

}