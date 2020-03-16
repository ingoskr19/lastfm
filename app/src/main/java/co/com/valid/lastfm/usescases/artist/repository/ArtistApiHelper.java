/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package co.com.valid.lastfm.usescases.artist.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.repository.service.ArtistRestApiService;
import co.com.valid.lastfm.util.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ArtistApiHelper implements IArtistApiHelper {

    ArtistRestApiService apiService;

    @Inject
    public ArtistApiHelper(ArtistRestApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<TopsArtistsResponse> getTopArtists(int page, int limit) {
        return apiService.getTopArtists(
                Constants.TOP_ARTISTS_METHOD,
                Constants.COUNTRY,
                BuildConfig.API_KEY,
                Constants.DATA_TYPE,
                page,
                limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

