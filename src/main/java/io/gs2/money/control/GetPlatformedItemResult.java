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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gs2.money.model.*;

/**
 * @author Game Server Services, Inc.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GetPlatformedItemResult {

	/** プラットフォーム個別商品 */
	private PlatformedItem item;


	/**
	 * プラットフォーム個別商品を取得
	 *
	 * @return プラットフォーム個別商品
	 */
	public PlatformedItem getItem() {
		return item;
	}

	/**
	 * プラットフォーム個別商品を設定
	 *
	 * @param item プラットフォーム個別商品
	 */
	public void setItem(PlatformedItem item) {
		this.item = item;
	}

}