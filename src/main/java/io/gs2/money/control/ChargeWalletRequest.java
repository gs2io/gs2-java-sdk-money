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
import io.gs2.control.Gs2UserRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class ChargeWalletRequest extends Gs2UserRequest<ChargeWalletRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "ChargeWallet";
	}

	/** 取得する仮想通貨の名前 */
	private String moneyName;

	/** 取得するウォレットのスロット番号 */
	private Integer slot;

	/** 支払金額 */
	private Double price;

	/** 仮想通貨付与量 */
	private Integer count;

	/** トランザクションID */
	private String transactionId;


	/**
	 * 取得する仮想通貨の名前を取得
	 *
	 * @return 取得する仮想通貨の名前
	 */
	public String getMoneyName() {
		return moneyName;
	}

	/**
	 * 取得する仮想通貨の名前を設定
	 *
	 * @param moneyName 取得する仮想通貨の名前
	 */
	public void setMoneyName(String moneyName) {
		this.moneyName = moneyName;
	}

	/**
	 * 取得する仮想通貨の名前を設定
	 *
	 * @param moneyName 取得する仮想通貨の名前
	 * @return this
	 */
	public ChargeWalletRequest withMoneyName(String moneyName) {
		setMoneyName(moneyName);
		return this;
	}

	/**
	 * 取得するウォレットのスロット番号を取得
	 *
	 * @return 取得するウォレットのスロット番号
	 */
	public Integer getSlot() {
		return slot;
	}

	/**
	 * 取得するウォレットのスロット番号を設定
	 *
	 * @param slot 取得するウォレットのスロット番号
	 */
	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	/**
	 * 取得するウォレットのスロット番号を設定
	 *
	 * @param slot 取得するウォレットのスロット番号
	 * @return this
	 */
	public ChargeWalletRequest withSlot(Integer slot) {
		setSlot(slot);
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
	public ChargeWalletRequest withPrice(Double price) {
		setPrice(price);
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
	public ChargeWalletRequest withCount(Integer count) {
		setCount(count);
		return this;
	}

	/**
	 * トランザクションIDを取得
	 *
	 * @return トランザクションID
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * トランザクションIDを設定
	 *
	 * @param transactionId トランザクションID
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * トランザクションIDを設定
	 *
	 * @param transactionId トランザクションID
	 * @return this
	 */
	public ChargeWalletRequest withTransactionId(String transactionId) {
		setTransactionId(transactionId);
		return this;
	}

}