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
public class DescribeReceiptRequest extends Gs2BasicRequest<DescribeReceiptRequest> {

	public static class Constant extends Gs2Money.Constant {
		public static final String FUNCTION = "DescribeReceipt";
	}

	/** 仮想通貨の名前 */
	String moneyName;

	/** データの取得開始日時(エポック秒)

省略すると30日前が指定されます */
	Integer begin;

	/** データの取得終了日時(エポック秒)

省略すると現在時刻が指定されます */
	Integer end;

	/** データの取得を開始する位置を指定するトークン

省略すると先頭から取得します */
	String pageToken;

	/** データの取得件数

省略すると30件取得します */
	Integer limit;


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
	public DescribeReceiptRequest withMoneyName(String moneyName) {
		setMoneyName(moneyName);
		return this;
	}

	/**
	 * データの取得開始日時(エポック秒)

省略すると30日前が指定されますを取得
	 *
	 * @return データの取得開始日時(エポック秒)

省略すると30日前が指定されます
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * データの取得開始日時(エポック秒)

省略すると30日前が指定されますを設定
	 *
	 * @param begin データの取得開始日時(エポック秒)

省略すると30日前が指定されます
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * データの取得開始日時(エポック秒)

省略すると30日前が指定されますを設定
	 *
	 * @param begin データの取得開始日時(エポック秒)

省略すると30日前が指定されます
	 * @return this
	 */
	public DescribeReceiptRequest withBegin(Integer begin) {
		setBegin(begin);
		return this;
	}

	/**
	 * データの取得終了日時(エポック秒)

省略すると現在時刻が指定されますを取得
	 *
	 * @return データの取得終了日時(エポック秒)

省略すると現在時刻が指定されます
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * データの取得終了日時(エポック秒)

省略すると現在時刻が指定されますを設定
	 *
	 * @param end データの取得終了日時(エポック秒)

省略すると現在時刻が指定されます
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}

	/**
	 * データの取得終了日時(エポック秒)

省略すると現在時刻が指定されますを設定
	 *
	 * @param end データの取得終了日時(エポック秒)

省略すると現在時刻が指定されます
	 * @return this
	 */
	public DescribeReceiptRequest withEnd(Integer end) {
		setEnd(end);
		return this;
	}

	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを取得
	 *
	 * @return データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 */
	public String getPageToken() {
		return pageToken;
	}

	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを設定
	 *
	 * @param pageToken データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 */
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを設定
	 *
	 * @param pageToken データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 * @return this
	 */
	public DescribeReceiptRequest withPageToken(String pageToken) {
		setPageToken(pageToken);
		return this;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを取得
	 *
	 * @return データの取得件数

省略すると30件取得します
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを設定
	 *
	 * @param limit データの取得件数

省略すると30件取得します
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを設定
	 *
	 * @param limit データの取得件数

省略すると30件取得します
	 * @return this
	 */
	public DescribeReceiptRequest withLimit(Integer limit) {
		setLimit(limit);
		return this;
	}

}