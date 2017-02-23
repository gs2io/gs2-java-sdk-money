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

import io.gs2.money.Gs2Money;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class ChargeWalletByUserRequest extends Gs2BasicRequest<ChargeWalletByUserRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "ChargeWalletByUser";
	}

	/** 仮想通貨の名前 */
	String moneyName;

	/** ウォレットのスロット番号 */
	Integer slot;

	/** ウォレットのユーザID */
	String userId;

	/** 仮想通貨付与量 */
	Integer count;

	/** 支払金額 */
	Double price;

	/** トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされます */
	String transactionId;


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
	public ChargeWalletByUserRequest withMoneyName(String moneyName) {
		setMoneyName(moneyName);
		return this;
	}

	/**
	 * ウォレットのスロット番号を取得
	 *
	 * @return ウォレットのスロット番号
	 */
	public Integer getSlot() {
		return slot;
	}

	/**
	 * ウォレットのスロット番号を設定
	 *
	 * @param slot ウォレットのスロット番号
	 */
	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	/**
	 * ウォレットのスロット番号を設定
	 *
	 * @param slot ウォレットのスロット番号
	 * @return this
	 */
	public ChargeWalletByUserRequest withSlot(Integer slot) {
		setSlot(slot);
		return this;
	}

	/**
	 * ウォレットのユーザIDを取得
	 *
	 * @return ウォレットのユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ウォレットのユーザIDを設定
	 *
	 * @param userId ウォレットのユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ウォレットのユーザIDを設定
	 *
	 * @param userId ウォレットのユーザID
	 * @return this
	 */
	public ChargeWalletByUserRequest withUserId(String userId) {
		setUserId(userId);
		return this;
	}

	/**
	 * 仮想通貨付与量を取得
	 *
	 * @return 仮想通貨付与量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 仮想通貨付与量を設定
	 *
	 * @param count 仮想通貨付与量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 仮想通貨付与量を設定
	 *
	 * @param count 仮想通貨付与量
	 * @return this
	 */
	public ChargeWalletByUserRequest withCount(Integer count) {
		setCount(count);
		return this;
	}

	/**
	 * 支払金額を取得
	 *
	 * @return 支払金額
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 支払金額を設定
	 *
	 * @param price 支払金額
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 支払金額を設定
	 *
	 * @param price 支払金額
	 * @return this
	 */
	public ChargeWalletByUserRequest withPrice(Double price) {
		setPrice(price);
		return this;
	}

	/**
	 * トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされますを取得
	 *
	 * @return トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされます
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされますを設定
	 *
	 * @param transactionId トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされます
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされますを設定
	 *
	 * @param transactionId トランザクションID
トランザクションIDが重複しているリクエストが届いた場合はリジェクトされます
	 * @return this
	 */
	public ChargeWalletByUserRequest withTransactionId(String transactionId) {
		setTransactionId(transactionId);
		return this;
	}

}