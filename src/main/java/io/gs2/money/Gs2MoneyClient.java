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

package io.gs2.money;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.gs2.AbstractGs2Client;
import io.gs2.Gs2Constant;
import io.gs2.model.IGs2Credential;
import io.gs2.money.control.*;

/**
 * GS2 Money API クライアント
 *
 * @author Game Server Services, Inc.
 *
 */
public class Gs2MoneyClient extends AbstractGs2Client<Gs2MoneyClient> {

	public static String ENDPOINT = "money";

	/**
	 * コンストラクタ。
	 *
	 * @param credential 認証情報
	 */
	public Gs2MoneyClient(IGs2Credential credential) {
		super(credential);
	}


	/**
	 * ウォレットを取得します<br>
	 * <br>
	 * ここでは有償仮想通貨と無償仮想通貨の数が取得できます。<br>
	 * 有償仮想通貨は単価ごとに所持数量が別途管理されています。<br>
	 * 詳細な構成を取得したい場合は Gs2Money:GetWalletDetail を使ってください。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetWalletResult getWallet(GetWalletRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet/" + request.getSlot() + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetWalletRequest.Constant.MODULE,
				GetWalletRequest.Constant.FUNCTION);

        get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(get, GetWalletResult.class);
	}


	/**
	 * レシートを検証する<br>
	 * <br>
	 * 下記フォーマットのレシートをPOSTすることでレシートを検証し、仮想通貨のチャージまでアトミックに実行できます。<br>
	 * {<br>
	 *   'Store': ストア名,<br>
	 *   'Payload': レシート本体<br>
	 * }<br>
	 * <br>
	 * 現在ストア名には<br>
	 * - AppleAppStore<br>
	 * - GooglePlay<br>
	 * が指定できます。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public VerifyResult verify(VerifyRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("slot", request.getSlot())
				.put("receipt", request.getReceipt());

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/verify",
				credential,
				ENDPOINT,
				VerifyRequest.Constant.MODULE,
				VerifyRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(post, VerifyResult.class);
	}


	/**
	 * 指定したユーザ・スロット番号のレシートを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeReceiptByUserAndSlotResult describeReceiptByUserAndSlot(DescribeReceiptByUserAndSlotRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/receipt/" + request.getUserId() + "/" + request.getSlot() + "";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getBegin() != null) queryString.add(new BasicNameValuePair("begin", String.valueOf(request.getBegin())));
        if(request.getEnd() != null) queryString.add(new BasicNameValuePair("end", String.valueOf(request.getEnd())));
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeReceiptByUserAndSlotRequest.Constant.MODULE,
				DescribeReceiptByUserAndSlotRequest.Constant.FUNCTION);

		return doRequest(get, DescribeReceiptByUserAndSlotResult.class);
	}


	/**
	 * 仮想通貨の状態を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetMoneyStatusResult getMoneyStatus(GetMoneyStatusRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/status";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetMoneyStatusRequest.Constant.MODULE,
				GetMoneyStatusRequest.Constant.FUNCTION);

		return doRequest(get, GetMoneyStatusResult.class);
	}


	/**
	 * ウォレットに仮想通貨をチャージします<br>
	 * <br>
	 * trasactionId にトランザクションIDを指定することで、<br>
	 * 1回の課金処理で複数回仮想通貨をチャージすることを防ぐことが出来ます。<br>
	 * 重複したリクエストが発生した場合は 409エラー(ConflictException) が発生しますが、正常処理とするべきです。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public ChargeWalletByUserResult chargeWalletByUser(ChargeWalletByUserRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("count", request.getCount())
				.put("price", request.getPrice());

        if(request.getTransactionId() != null) body.put("transactionId", request.getTransactionId());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet/" + request.getSlot() + "/" + request.getUserId() + "/charge",
				credential,
				ENDPOINT,
				ChargeWalletByUserRequest.Constant.MODULE,
				ChargeWalletByUserRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, ChargeWalletByUserResult.class);
	}


	/**
	 * ウォレットの詳細を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetWalletDetailResult getWalletDetail(GetWalletDetailRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet/" + request.getSlot() + "/" + request.getUserId() + "/detail";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetWalletDetailRequest.Constant.MODULE,
				GetWalletDetailRequest.Constant.FUNCTION);

		return doRequest(get, GetWalletDetailResult.class);
	}


	/**
	 * 仮想通貨を更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public UpdateMoneyResult updateMoney(UpdateMoneyRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("priority", request.getPriority())
				.put("useVerifyReceipt", request.getUseVerifyReceipt())
				.put("description", request.getDescription());

        if(request.getGoogleKey() != null) body.put("googleKey", request.getGoogleKey());
        if(request.getAppleKey() != null) body.put("appleKey", request.getAppleKey());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "",
				credential,
				ENDPOINT,
				UpdateMoneyRequest.Constant.MODULE,
				UpdateMoneyRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(put, UpdateMoneyResult.class);
	}


	/**
	 * 仮想通貨を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetMoneyResult getMoney(GetMoneyRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetMoneyRequest.Constant.MODULE,
				GetMoneyRequest.Constant.FUNCTION);

		return doRequest(get, GetMoneyResult.class);
	}


	/**
	 * 仮想通貨を削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */
	public void deleteMoney(DeleteMoneyRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "",
				credential,
				ENDPOINT,
				DeleteMoneyRequest.Constant.MODULE,
				DeleteMoneyRequest.Constant.FUNCTION);

		doRequest(delete, null);
	}


	/**
	 * プラットフォーム個別商品を更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public UpdatePlatformedItemResult updatePlatformedItem(UpdatePlatformedItemRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("price", request.getPrice())
				.put("name", request.getName());

		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "/platformedItem/" + request.getPlatform() + "",
				credential,
				ENDPOINT,
				UpdatePlatformedItemRequest.Constant.MODULE,
				UpdatePlatformedItemRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(put, UpdatePlatformedItemResult.class);
	}


	/**
	 * プラットフォーム個別商品を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetPlatformedItemResult getPlatformedItem(GetPlatformedItemRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "/platformedItem/" + request.getPlatform() + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetPlatformedItemRequest.Constant.MODULE,
				GetPlatformedItemRequest.Constant.FUNCTION);

		return doRequest(get, GetPlatformedItemResult.class);
	}


	/**
	 * プラットフォーム個別商品を削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */
	public void deletePlatformedItem(DeletePlatformedItemRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "/platformedItem/" + request.getPlatform() + "",
				credential,
				ENDPOINT,
				DeletePlatformedItemRequest.Constant.MODULE,
				DeletePlatformedItemRequest.Constant.FUNCTION);

		doRequest(delete, null);
	}


	/**
	 * ウォレット一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeWalletResult describeWallet(DescribeWalletRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));
        if(request.getUserId() != null) queryString.add(new BasicNameValuePair("userId", String.valueOf(request.getUserId())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeWalletRequest.Constant.MODULE,
				DescribeWalletRequest.Constant.FUNCTION);

		return doRequest(get, DescribeWalletResult.class);
	}


	/**
	 * 商品を新規作成します<br>
	 * <br>
	 * このデータは GS2-Money のレシート検証機能を利用するときにのみ登録する必要があります。<br>
	 * これはレシート検証の結果妥当だった場合対価として仮想通貨を付与するために、<br>
	 * どのような価値の仮想通貨をいくらで販売しているのかという情報を GS2-Money が持っていなければサービスを実現できないためです。<br>
	 * <br>
	 * - 商品(仮想通貨 60個)<br>
	 * -- プラットフォーム個別商品(AppleAppStore 120円)<br>
	 * -- プラットフォーム個別商品(GooglePlay 120円)<br>
	 * <br>
	 * という構造で商品を登録する必要があります。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public CreateItemResult createItem(CreateItemRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("count", request.getCount())
				.put("name", request.getName());

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item",
				credential,
				ENDPOINT,
				CreateItemRequest.Constant.MODULE,
				CreateItemRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, CreateItemResult.class);
	}


	/**
	 * 商品の一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeItemResult describeItem(DescribeItemRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeItemRequest.Constant.MODULE,
				DescribeItemRequest.Constant.FUNCTION);

		return doRequest(get, DescribeItemResult.class);
	}


	/**
	 * レシートを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeReceiptResult describeReceipt(DescribeReceiptRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/receipt";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getBegin() != null) queryString.add(new BasicNameValuePair("begin", String.valueOf(request.getBegin())));
        if(request.getEnd() != null) queryString.add(new BasicNameValuePair("end", String.valueOf(request.getEnd())));
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeReceiptRequest.Constant.MODULE,
				DescribeReceiptRequest.Constant.FUNCTION);

		return doRequest(get, DescribeReceiptResult.class);
	}


	/**
	 * 商品を更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public UpdateItemResult updateItem(UpdateItemRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("count", request.getCount());

		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "",
				credential,
				ENDPOINT,
				UpdateItemRequest.Constant.MODULE,
				UpdateItemRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(put, UpdateItemResult.class);
	}


	/**
	 * 商品を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetItemResult getItem(GetItemRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetItemRequest.Constant.MODULE,
				GetItemRequest.Constant.FUNCTION);

		return doRequest(get, GetItemResult.class);
	}


	/**
	 * 商品を削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */
	public void deleteItem(DeleteItemRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "",
				credential,
				ENDPOINT,
				DeleteItemRequest.Constant.MODULE,
				DeleteItemRequest.Constant.FUNCTION);

		doRequest(delete, null);
	}


	/**
	 * プラットフォーム個別商品を新規作成します<br>
	 * <br>
	 * name には各プラットフォームの管理コンソールで作成した消費型アイテムの名前を指定してください。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public CreatePlatformedItemResult createPlatformedItem(CreatePlatformedItemRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("platform", request.getPlatform())
				.put("price", request.getPrice())
				.put("name", request.getName());

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "/platformedItem",
				credential,
				ENDPOINT,
				CreatePlatformedItemRequest.Constant.MODULE,
				CreatePlatformedItemRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, CreatePlatformedItemResult.class);
	}


	/**
	 * プラットフォーム個別商品の一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribePlatformedItemResult describePlatformedItem(DescribePlatformedItemRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/item/" + request.getItemName() + "/platformedItem";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribePlatformedItemRequest.Constant.MODULE,
				DescribePlatformedItemRequest.Constant.FUNCTION);

		return doRequest(get, DescribePlatformedItemResult.class);
	}


	/**
	 * ウォレットに仮想通貨をチャージします<br>
	 * <br>
	 * trasactionId にトランザクションIDを指定することで、<br>
	 * 1回の課金処理で複数回仮想通貨をチャージすることを防ぐことが出来ます。<br>
	 * 重複したリクエストが発生した場合は 409エラー(ConflictException) が発生しますが、正常処理とするべきです。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public ChargeWalletResult chargeWallet(ChargeWalletRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("count", request.getCount())
				.put("price", request.getPrice());

        if(request.getTransactionId() != null) body.put("transactionId", request.getTransactionId());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet/" + request.getSlot() + "/charge",
				credential,
				ENDPOINT,
				ChargeWalletRequest.Constant.MODULE,
				ChargeWalletRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(post, ChargeWalletResult.class);
	}


	/**
	 * 仮想通貨を新規作成します<br>
	 * <br>
	 * priority には仮想通貨の消費優先度を指定することが出来ます。<br>
	 * 無償仮想通貨を優先して消費する場合は free を、有償仮想通貨を優先して消費する場合は paid を指定します。<br>
	 * 資金決済法への対応としては有償仮想通貨を優先して消費するほうが未使用残高が溜まりにくく効率的ですが、<br>
	 * 有償仮想通貨でしか購入できないアイテムを提供している場合はユーザの心象は悪いかもしれません。<br>
	 * <br>
	 * ユーザごとにウォレットという財布のようなものを用意し、仮想通貨はそこにチャージされます。<br>
	 * ウォレットにはスロットという概念があり、各ユーザ複数の財布を持つことが出来ます。<br>
	 * これはガイドラインによってプラットフォームごとに仮想通貨を分けて管理する必要があるためです。<br>
	 * このガイドラインは有償仮想通貨にのみ適用される者で、無償仮想通貨はその義務は生じません。<br>
	 * そのため shareFree という設定値があり、ここを true に設定することですべてのスロットで無償仮想通貨を共有することができるようになります。<br>
	 * この際、あらゆるスロットにアクセスしても無償仮想通貨に関してはスロット0の仮想通貨が利用される。という挙動を取ります。<br>
	 * <br>
	 * useVerifyReceipt で課金時に各プラットフォームから取得できるレシートを検証する機能を利用できるようになります。<br>
	 * レシートの検証機能を利用する場合は各プラットフォームごとに検証に必要な要素を登録しておく必要があります。<br>
	 * <br>
	 * AppleAppStore におけるレシートの検証を実現するには appleKey を指定します。<br>
	 * appleKey にはアプリケーションの bundle_id を指定してください。<br>
	 * 異なるアプリケーションで決済されたトランザクションで仮想通貨をチャージすることを防ぐ意味があります。<br>
	 * <br>
	 * GooglePlay におけるレシートの検証を実現するには googleKey を指定します。<br>
	 * googleKey には Google Play Developer Console で取得できる公開鍵を指定してください。<br>
	 * レシートが改ざんされていないか検証するために利用します。<br>
	 * <br>
	 * GS2-Money は資金決済法における前払式支払手段(自家型)に対応します。<br>
	 * マネージメントコンソールやAPIで取得できる未使用残高が1,000万円を超えると法的な責任が発生します。<br>
	 * 詳しくはドキュメントを参照してください。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public CreateMoneyResult createMoney(CreateMoneyRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("useVerifyReceipt", request.getUseVerifyReceipt())
				.put("name", request.getName())
				.put("priority", request.getPriority())
				.put("shareFree", request.getShareFree())
				.put("description", request.getDescription());

        if(request.getGoogleKey() != null) body.put("googleKey", request.getGoogleKey());
        if(request.getCurrency() != null) body.put("currency", request.getCurrency());
        if(request.getAppleKey() != null) body.put("appleKey", request.getAppleKey());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money",
				credential,
				ENDPOINT,
				CreateMoneyRequest.Constant.MODULE,
				CreateMoneyRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, CreateMoneyResult.class);
	}


	/**
	 * 仮想通貨の一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeMoneyResult describeMoney(DescribeMoneyRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/money";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeMoneyRequest.Constant.MODULE,
				DescribeMoneyRequest.Constant.FUNCTION);

		return doRequest(get, DescribeMoneyResult.class);
	}


	/**
	 * ウォレットから仮想通貨を消費します<br>
	 * <br>
	 * paidOnly に true を指定することで、有償仮想通貨のみ消費対象とすることが出来ます。<br>
	 * プレミアムなサービスの提供時などに活用してください。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public ConsumeWalletResult consumeWallet(ConsumeWalletRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("count", request.getCount())
				.put("use", request.getUse());

        if(request.getPaidOnly() != null) body.put("paidOnly", request.getPaidOnly());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/money/" + request.getMoneyName() + "/wallet/" + request.getSlot() + "/consume",
				credential,
				ENDPOINT,
				ConsumeWalletRequest.Constant.MODULE,
				ConsumeWalletRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(post, ConsumeWalletResult.class);
	}


}