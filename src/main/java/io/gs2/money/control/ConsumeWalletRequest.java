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
import io.gs2.control.Gs2UserRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class ConsumeWalletRequest extends Gs2UserRequest<ConsumeWalletRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "ConsumeWallet";
	}

	/** 取得する仮想通貨の名前 */
	String moneyName;

	/** 取得するウォレットのスロット番号 */
	Integer slot;

	/** 仮想通貨消費量 */
	Integer count;

	/** 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されます */
	Boolean paidOnly;

	/** 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できます */
	Integer use;


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
	public ConsumeWalletRequest withMoneyName(String moneyName) {
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
	public ConsumeWalletRequest withSlot(Integer slot) {
		setSlot(slot);
		return this;
	}

	/**
	 * 仮想通貨消費量を取得
	 *
	 * @return 仮想通貨消費量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 仮想通貨消費量を設定
	 *
	 * @param count 仮想通貨消費量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 仮想通貨消費量を設定
	 *
	 * @param count 仮想通貨消費量
	 * @return this
	 */
	public ConsumeWalletRequest withCount(Integer count) {
		setCount(count);
		return this;
	}

	/**
	 * 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されますを取得
	 *
	 * @return 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されます
	 */
	public Boolean getPaidOnly() {
		return paidOnly;
	}

	/**
	 * 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されますを設定
	 *
	 * @param paidOnly 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されます
	 */
	public void setPaidOnly(Boolean paidOnly) {
		this.paidOnly = paidOnly;
	}

	/**
	 * 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されますを設定
	 *
	 * @param paidOnly 有償仮想通貨のみ消費対象としたい場合に true を指定します
無償仮想通貨では受けられないサービスの決済時に使用します

省略した場合は false が適用されます
	 * @return this
	 */
	public ConsumeWalletRequest withPaidOnly(Boolean paidOnly) {
		setPaidOnly(paidOnly);
		return this;
	}

	/**
	 * 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できますを取得
	 *
	 * @return 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できます
	 */
	public Integer getUse() {
		return use;
	}

	/**
	 * 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できますを設定
	 *
	 * @param use 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できます
	 */
	public void setUse(Integer use) {
		this.use = use;
	}

	/**
	 * 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できますを設定
	 *
	 * @param use 用途ID

- リトライ: 0
- ボックス拡張: 1
- ガチャ: 2

のように用途ごとに異なるIDを付与しておくことで、仮想通貨の用途ごとの消費統計を計算できます
	 * @return this
	 */
	public ConsumeWalletRequest withUse(Integer use) {
		setUse(use);
		return this;
	}

}