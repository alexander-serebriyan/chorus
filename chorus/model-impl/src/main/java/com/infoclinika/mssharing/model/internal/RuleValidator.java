package com.infoclinika.mssharing.model.internal;

import com.google.common.base.Predicate;
import com.infoclinika.mssharing.model.internal.entity.Instrument;
import com.infoclinika.mssharing.model.internal.entity.Lab;
import com.infoclinika.mssharing.model.internal.entity.UploadAppConfiguration;
import com.infoclinika.mssharing.model.internal.entity.restorable.*;
import com.infoclinika.mssharing.platform.model.read.AccessLevel;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Pavel Kaplin
 */
public interface RuleValidator extends com.infoclinika.mssharing.platform.model.RuleValidator {

    boolean userHasPermissionToCreateSearch(long creator, long experiment);

    boolean isAllFilesInExperimentTranslatedForSearch(long experiment);

    Predicate<ActiveFileMetaData> userHasReadPermissionsOnFilePredicate(long userId);

    AccessLevel getAccessLevel(AbstractFileMetaData input);

    Predicate<ActiveFileMetaData> filesFromMatchedProjectsPredicate(Predicate<AbstractProject> projectPredicate);

    boolean canAccessExistingInstrument(long actor, String serialNumber);


    boolean canReadLabBilling(long actor, long lab);

    boolean isProjectOwner(long actor, long projectId);


    boolean canReadUsersInLab(long labHead, long labId);


    boolean canRestoreProject(long actor, DeletedProject projectId);

    boolean projectHasDuplicateNames(long owner, DeletedProject project);

    boolean canRestoreExperiment(long actor, DeletedExperiment experiment);

    boolean experimentHasDuplicateNames(long owner, DeletedExperiment experiment);

    boolean canRemoveProteinSearch(long actor, long experimentRunId);

    boolean canRestoreFile(long actor, DeletedFileMetaData file);

    boolean fileHasDuplicateName(DeletedFileMetaData file);


    Predicate<ActiveExperiment> isUserCanReadExperimentPredicate(long actor);

    Predicate<Instrument> isUserCanReadInstrumentPredicate(long actor);

    boolean isUserCanReadProteinSearches(long actor, long experimentId);


    boolean canUserCreateProteinSearchWithTitle(long actor, long experiment, String title);


    boolean userHasPermissionToRetranslateAllExperiments(long actor);

    boolean userCanReadExperimentTranslationStatuses(long actor);

    boolean hasAdminRights(long actor);

    boolean userHasPermissionToRunProteinIDSearches(long actor, List<Long> experimentSearches);

    boolean userCanReadProteinSearchStatuses(long actor);

    boolean canManageNews(long actor);


    boolean isUploadAppConfigurationOwner(long actor, UploadAppConfiguration configuration);

    boolean isExperimentReadyToDownload(ActiveExperiment experiment);


    boolean canTranslateFile(long actor, long lab, long fileId);

    boolean canReTranslateFiles(long actor, List<Long> files);

    boolean canModifyProteinDatabase(long actor, long proteinDatabase);

    boolean canReadProteinDatabase(long actor, long proteinDatabase);

    boolean canTranslateExperimentFiles(long actor, @Nullable Long chargedLab, ActiveExperiment experiment);

    boolean canArchiveFile(long actor, long file);

    boolean canUnarchiveFile(long actor, long file);

    boolean canArchiveExperiment(long actor, ActiveExperiment experiment);

    boolean canUnarchiveExperiment(long actor, ActiveExperiment experiment);

    boolean isBillingEnabledForLab(long lab);

    boolean isSearchResultsFeatureEnabledForLab(long lab);

    boolean canUserAccessSearchResults(long actor, long run);

    boolean isTranslationEnabledForLab(long lab);

    boolean canLabUseProteinIdSearch(long lab);

    boolean canCreateWorkflow(long actor);

    boolean isUserCanReadWorkflow(long actor);

    boolean canRemoveTranslationData(long actor, long file, long lab);

    boolean canRemoveAnyExperimentTranslationData(long actor, long experiment);

    boolean canModifyAnnotationAttachment(long actor, long annotationAttachment);

    /*Defines whether user is able to persist proteins from protein database file(e.g. fasta)*/
    boolean hasRightsToPersistProteins(long actor, long db);

    boolean canModifyAnalysis(long actor, long analysis);

    boolean canModifyAnalysisTemplate(long actor, long analysisTemplate);

    boolean isLabHead(long actor, long lab);

    boolean canCreatePostProcessingPipeline(long actor);
    
    boolean canUserManageLabAccount(long actor, long lab);

    boolean canImportMicroArrays(long actor, long lab);

    boolean shouldSearchResultsBePersistedInBlibFile(long run);

    boolean canUserReadProteinSearchAttachment(long actor, long attachmentId);

    boolean canUserManageProteinSearchAttachments(long actor);

    boolean canUserManageProteinSearchAttachment(long actor, long attachmentId);

    boolean isProteinSearchOwner(long actor, long proteinSearchId);

}
